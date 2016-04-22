package com.ccniit.graduation.plus.lucene;

import java.io.File;
import java.io.IOException;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field.Store;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;

import com.ccniit.graduation.pojo.db.VoteContent;
import com.ccniit.graduation.util.LoggerUtils;

@Component("voteIndex")
public class VoteIndex {

	private static final Logger DEV = LoggerUtils.getDev();

	private static final String VOTE_INDEX_PATH = "H:/voteIndex";
	private static final String INDEX_FIELD_CONTENT = "content";
	private static final String INDEX_FIELD_ID = "id";

	private Directory getDirectory() {
		File indexFile = new File(VOTE_INDEX_PATH);
		try {
			return FSDirectory.open(indexFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	@SuppressWarnings("resource")
	public void addVoteToIndex(VoteContent voteContent) {

		try {
			Analyzer analyzer = new StandardAnalyzer();
			IndexWriterConfig indexWriterConfig = new IndexWriterConfig(Version.LATEST, analyzer);
			IndexWriter indexWriter = new IndexWriter(getDirectory(), indexWriterConfig);

			if (indexed(voteContent.getId())) {
				DEV.info("this doc indexed,vote {}!", voteContent.getId());
				return;
			}

			Document document = new Document();
			document.add(new TextField(INDEX_FIELD_CONTENT, voteContent.getContent(), Store.YES));
			document.add(new TextField(INDEX_FIELD_ID, String.valueOf(voteContent.getId()), Store.YES));
			indexWriter.addDocument(document);

			indexWriter.commit();
			indexWriter.close();

		} catch (IOException e) {
			// TODO log
		}
	}

	// 检测是非应经索引过
	public boolean indexed(Long vote) {
		String voteId = String.valueOf(vote);
		try {
			IndexSearcher searcher = new IndexSearcher(DirectoryReader.open(getDirectory()));
			QueryParser queryParser = new QueryParser(voteId, new StandardAnalyzer());
			Query query = queryParser.parse(INDEX_FIELD_ID);
			TopDocs docs = searcher.search(query, 1);

			if (0 == docs.totalHits) {
				return false;
			}

			Document document = searcher.doc(docs.scoreDocs[0].doc);
			Long voteRealDoc = Long.parseLong(document.getField(INDEX_FIELD_ID).stringValue());
			if (vote == voteRealDoc) {
				return true;
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public void searchVote(String keywords) {

		try {
			IndexReader indexReader = DirectoryReader.open(getDirectory());
			IndexSearcher indexSearcher = new IndexSearcher(indexReader);

			Analyzer analyzer = new StandardAnalyzer();
			QueryParser queryParser = new QueryParser("content", analyzer);
			Query query = null;
			query = queryParser.parse(keywords);
			TopDocs docs = indexSearcher.search(query, 10);
			ScoreDoc[] scoreDocs = docs.scoreDocs;

			ScoreDoc scoreDoc = null;
			for (int i = 0; i < scoreDocs.length; i++) {
				scoreDoc = scoreDocs[i];
				Document document = indexSearcher.doc(scoreDoc.doc);

				DEV.info("{}:{}", INDEX_FIELD_ID, document.getField(INDEX_FIELD_ID).stringValue());
				DEV.info("score:{}", scoreDoc.score);
			}

		} catch (Exception e) {

		}
	}

	public static void main(String[] args) {
		new VoteIndex().searchVote("分析");
	}

}
