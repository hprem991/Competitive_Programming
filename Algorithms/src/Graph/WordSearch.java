package Graph;
import java.util.*;
import java.lang.*;


//Given a 2D board and a word, find if the word exists in the grid.
//http://www.programcreek.com/2014/06/leetcode-word-search-java/

public class WordSearch {
	
	// dfs implementation
	boolean dfs(char[][] board, String word, int i, int j, int index){
		if( (i < 0) || (j < 0) || (i > board.length - 1) || ( j > board[0].length - 1))
			return false;
		if(board[i][j] == word.charAt(index)){
			char temp = board[i][j];
			board[i][j] = '#';
			if(index == word.length() - 1) // Found the word
				return true;
			else {
				if(dfs(board, word, i + 1, j, index + 1) ||
				   dfs(board, word, i - 1, j, index + 1) ||
				   dfs(board, word, i , j + 1, index + 1) ||
				   dfs(board, word, i , j - 1, index + 1)) {
					return true;
				}
				board[i][j] = temp;
			}
		}
		return false;
	}
	
	public boolean exist(char[][] board, String word) {
	
		for(int i = 0; i < board.length; i++){
			for(int j = 0; j< board[0].length; j++){
				if(dfs(board, word, i, j, 0)){
					return true;
				}
			}
		}		
		return false;
	}
}
