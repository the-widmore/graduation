package com.ccniit.graduation.plus.lucene;

import java.util.List;

import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field.Store;
import org.apache.lucene.document.LongField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.search.TopDocs;
import org.springframework.stereotype.Component;

import com.ccniit.graduation.pojo.db.VoteContent;

@Component("voteContentIndexHandle")
public class VoteContentIndexHandle extends LuceneTools {

	public static final String VOTE_ID_FIELD = "id";
	public static final String VOTE_CONTENT_FIELD = "content";

	//
	private static final int DEFAUT_SEARCH_PAGE_SIZE = 10;

	public VoteContentIndexHandle() {

	}

	public void addVoteContentToIndex(VoteContent voteContent) {
		if (null == voteContent.getContent()) {
			return;
		}
		IndexWriter indexWriter = getIndexWriter();
		Document document = new Document();
		document.add(new LongField(VOTE_ID_FIELD, voteContent.getId(), Store.YES));
		document.add(new TextField(VOTE_CONTENT_FIELD, voteContent.getContent(), Store.NO));
		addDocument(indexWriter, document);
	}

	public Document searchVoteContentById(Long voteId) {
		List<Document> documents = searchDocument(getIndexReader(), VOTE_ID_FIELD, String.valueOf(voteId), 1);
		return documents.get(0);
	}

	public TopDocs searchVoteContentFromIndex(String key) {
		return search(getIndexReader(), VOTE_CONTENT_FIELD, key, DEFAUT_SEARCH_PAGE_SIZE);
	}

	@Override
	List<Document> searchDocument(IndexReader indexReader, String field, String key, int pageSize) {
		return super.searchDocument(indexReader, field, key, pageSize);
	}

}
