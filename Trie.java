import java.util.ArrayList;
import java.util.List;

public class Trie {
	private TrieNode root;

	public Trie() {
		root = new TrieNode();
	}

	public void addWord( String word ) {
		root.addWord( word.toLowerCase() );
	}

	public List getWords( String prefix ) {
		//Find the node which represents the last letter of the prefix
		TrieNode lastNode = root;
		for ( int i = 0; i < prefix.length(); i++ ) {
			lastNode = lastNode.getNode( prefix.charAt( i ) );

			//If no node matches, then no words exist, return empty list
			if ( lastNode == null ) return new ArrayList();
		}
		//Return the words which eminate from the last node
		return lastNode.getWords();
	}
}

public class TrieNode {
	private TrieNode parent;
	private TrieNode[] children;
	private boolean isLeaf;
	private boolean isWord;
	private char character;

	public TrieNode() {
		children = new TrieNode[ 26 ];
		isLeaf = true;
		isWord = false;
	}

	public TrieNode( char character ) {
		this();
		this.character = character;
	}

	protected void addWord( String word ) {
		isLeaf = false;
		int charPos = word.charAt( 0 ) - 'a';

		if ( children[ charPos ] == null ) {
			children[ charPos ] = new TrieNode( word.charAt( 0 ) );
			children[ charPos ].parent = this;
		}

		if ( word.length() > 1 ) {
			children[ charPos ].addWord( word.substring( 1 ) );
		} else {
			children[ charPos ].isWord = true;
		}
	}

	protected TrieNode getNode( char c ) {
		return children[ c - 'a' ];
	}

	protected List getWords() {
		List list = new ArrayList();

		if ( isWord ) {
			list.add( toString() );
		}

		if ( !isLeaf ) {
			for ( int i = 0; i < children.length; i++ ) {
				if ( children[ i ] != null ) {
					list.addAll( children.getWords() );
				}
			}
		}
		return list;
	}

	public String toString() {
		if ( parent == null ) {
			int a = 40;
			return "";
		} else {
			return parent.toString() + new String( new char[] {
				character
			} );
		}
	}
}
