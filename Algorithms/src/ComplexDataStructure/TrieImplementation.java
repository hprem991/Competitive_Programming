package ComplexDataStructure;


// This is a Trie Implementation

class TrieNode{
	boolean m_isEnd;
	TrieNode m_childs[];
	
	TrieNode (/*int aNodes*/) { // You Never Know if 
		m_childs = new TrieNode[26];
		m_isEnd = false;	
		
		for(int i = 0; i < 26; i++) {
			m_childs[i] = null;
		}
	}
}

public class Trie {
	// Assume all Characters are in lowercase , will hander upperCase later
	public void insert(TrieNode root, String aString) {
		char characters[] = aString.toCharArray();
		for(int  i =  0; i < characters.length; i++) {
			char c =  characters[i];
			if(root.m_childs[c - 'a'] != null) { // If there is already a hashed value, we wont do anything 
				if(!root.m_isEnd && (i == characters.length)) // If this node hasnt been marked as end node but the current char makes it
					root.m_isEnd = true;
			} else {
				TrieNode node = new TrieNode();
				if(i == characters.length) // If this is the last character of the input string
					node.m_isEnd = true;
				root.m_childs[c - 'a'] = node ; 
			}
		}
	}
	
	public boolean search(TrieNode root, String aString) {
		char []chars = aString.toCharArray();
		for(int i = 0; i < chars.length; i++) {
			if(root.m_childs[chars[i] - 'a'] == null) { // Not Found 
				return false;
			} else {
				if(i == chars.length) { // if we have reached the end 
					return root.m_isEnd;
				}
			}
			root = root.m_childs[chars[i] - 'a'];
		}
		return false;
	}
}

