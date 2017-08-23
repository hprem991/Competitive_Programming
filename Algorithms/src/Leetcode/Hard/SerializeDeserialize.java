package Leetcode.Hard;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

class Tree{
	int val;
	Tree left;
	Tree right;
}


// This is Java Version which has a lot of Stream related System Issues Better code in C++ 
public class SerializeDeserialize {
	
	//Serialization
	 public String serialize(Tree root){
		 OutputStream out;
		 return Serialize(out, root);
	 }
	 
	 String Serialize(OutputStream out, Tree root){
		 if(root == null){
			 return "#";
		 } else {
			 out.write(root.val);
			 Serialize(out, root.left);
			 Serialize(out, root.right);
		 }
		 return out.toString(); // Just for the sake of matching
	 }
	 
	 
	 //Deserialization
	 public Tree deserialize(String data){
		 InputStream in(data); // Watch Out for Syntax
		 return deserialize(in);
	 }
	 
	 Tree deserialize(InputStream in){
		 int val = in.read(); // Watch Out for Syntax
		 if(val == Integer.parseInt("#"))
		 	{
			 	return null;
		 	} 
		 else {
			 Tree node =  new Tree();
			 node.val = val;
			 node.left = deserialize(in);
			 node.right = deserialize(in);
			 return node;
		  }	 
	 }
	 
}
