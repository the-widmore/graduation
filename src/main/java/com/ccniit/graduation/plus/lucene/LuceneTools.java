package com.ccniit.graduation.plus.lucene;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
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

import com.ccniit.graduation.util.LoggerUtils;

public class LuceneTools {

	private static final Logger DEV = LoggerUtils.getDev();

	private static final String VOTE_INDEX_PATH = "H:/voteIndex";

	public Directory getDirectory() {
		return getDirectory(VOTE_INDEX_PATH);
	}

	private Directory getDirectory(String indexPath) {
		File file = new File(indexPath);
		if (!file.isDirectory()) {
			DEV.error("indexPath 必须是一个文件夹");
			return null;
		}
		Directory directory = null;
		try {
			directory = FSDirectory.open(file);
		} catch (IOException e) {
		}
		return directory;
	}

	/**
	 * 获取分析器
	 */
	public Analyzer getAnalyzer() {
		return new StandardAnalyzer();
	}

	/**
	 * 写入索引
	 */
	public IndexWriter getIndexWriter() {

		IndexWriter indexWriter = null;
		try {
			IndexWriterConfig config = new IndexWriterConfig(Version.LATEST, getAnalyzer());
			indexWriter = new IndexWriter(getDirectory(), config);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return indexWriter;
	}

	/**
	 * 读取索引
	 */
	public IndexReader getIndexReader() {
		IndexReader indexReader = null;
		try {
			indexReader = DirectoryReader.open(getDirectory());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return indexReader;
	}

	/**
	 * 添加文档
	 */
	public void addDocument(IndexWriter indexWriter, Document document) {
		try {

			if (null == indexWriter) {
				System.out.println("indexWriter is null");
			}

			indexWriter.addDocument(document);
			indexWriter.commit();
			indexWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 搜索文档
	 * 
	 * @param indexReader
	 *            IndexReader
	 * @param field
	 *            要搜索的文档的域
	 * @param key
	 *            搜索关键字
	 * @param pageSize
	 *            返回的结果条数
	 * @return @see org.apache.lucene.search.TopDocs
	 */
	public TopDocs search(IndexReader indexReader, final String field, String key, int pageSize) {
		IndexSearcher indexSearcher = new IndexSearcher(indexReader);
		QueryParser queryParser = new QueryParser(field, getAnalyzer());
		TopDocs topDocs = null;
		try {
			Query query = queryParser.parse(key);
			topDocs = indexSearcher.search(query, pageSize);
		} catch (ParseException e) {
			//
		} catch (IOException e) {
			//
		}
		return topDocs;
	}

	List<Document> searchDocument(IndexReader indexReader, final String field, String key, int pageSize) {
		List<Document> documents = new ArrayList<>();
		IndexSearcher indexSearcher = new IndexSearcher(indexReader);
		QueryParser queryParser = new QueryParser(field, getAnalyzer());
		TopDocs topDocs = null;
		try {
			Query query = queryParser.parse(key);
			topDocs = indexSearcher.search(query, pageSize);
			ScoreDoc[] scoreDocs = topDocs.scoreDocs;
			for (int i = 0; i < scoreDocs.length; i++) {
				documents.add(indexSearcher.doc(scoreDocs[i].doc));
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return documents;
	}

}
