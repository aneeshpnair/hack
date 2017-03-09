package com.hack;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

enum Color {
    RED, GREEN
}

abstract class Tree {

    private int value;
    private Color color;
    private int depth;

    public Tree(int value, Color color, int depth) {
        this.value = value;
        this.color = color;
        this.depth = depth;
    }

    public int getValue() {
        return value;
    }

    public Color getColor() {
        return color;
    }

    public int getDepth() {
        return depth;
    }

    public abstract void accept(TreeVis visitor);
}

class TreeNode extends Tree {

    private ArrayList<Tree> children = new ArrayList<>();

    public TreeNode(int value, Color color, int depth) {
        super(value, color, depth);
    }

    public void accept(TreeVis visitor) {
        visitor.visitNode(this);

        for (Tree child : children) {
            child.accept(visitor);
        }
    }

    public void addChild(Tree child) {
        children.add(child);
    }
}

class TreeLeaf extends Tree {

    public TreeLeaf(int value, Color color, int depth) {
        super(value, color, depth);
    }

    public void accept(TreeVis visitor) {
        visitor.visitLeaf(this);
    }
}


abstract class TreeVis
{
    public abstract int getResult();
    public abstract void visitNode(TreeNode node);
    public abstract void visitLeaf(TreeLeaf leaf);

}
class SumInLeavesVisitor extends TreeVis {
	int sum = 0;
    public int getResult() {
      	//implement this
        return sum;
    }

    public void visitNode(TreeNode node) {
      	//implement this
    }

    public void visitLeaf(TreeLeaf leaf) {
    	sum += leaf.getValue();
    }
}

class ProductOfRedNodesVisitor extends TreeVis {
	long product = 1;
    public int getResult() {
        return (int) (product % 1000000007) ;
    }

    public void visitNode(TreeNode node) {
    	multiply(node);
    }

    public void visitLeaf(TreeLeaf leaf) {
    	multiply(leaf);
    }
    private void multiply(Tree t){
    	if(t.getColor() == Color.RED){
    		int v = t.getValue() == 0 ? 1 : t.getValue();
    		product *= v;
    	}
    }
}

class FancyVisitor extends TreeVis {
	int nlned = 0;
	int gln = 0;
    public int getResult() {
      	//implement this
        return Math.abs(nlned - gln);
    }

    public void visitNode(TreeNode node) {
    	if(node.getDepth() % 2 == 0){
    		nlned += node.getValue();
    	}
    }

    public void visitLeaf(TreeLeaf leaf) {
    	if(leaf.getColor() == Color.GREEN){
    		gln += leaf.getValue();
    	}
    }
}
class TempNode extends Tree{

	public ArrayList<TempNode> childList = new ArrayList<>();
	public int dep;

	public TempNode(int value, Color color, int depth) {
		super(value, color, depth);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void accept(TreeVis visitor) {
		// TODO Auto-generated method stub
		
	}

}
public class TreeVisitor {
  
    public static Tree solve() {
        Scanner sc = new Scanner(System.in);
        int nNodes = sc.nextInt();
        sc.nextLine();
        String values = sc.nextLine();
        String[] aValues = values.split(" ");
        String colors = sc.nextLine();
        String[] aColors = colors.split(" ");
        
        List<TempNode> lNodes = new ArrayList<TempNode>();
        for(int i = 0; i < nNodes; ++i){
        	TempNode node = new TempNode(Integer.valueOf(aValues[i]), getColor(Integer.valueOf(aColors[i])), 0);
        	lNodes.add(node);
        }
        for(int i = 0; i < nNodes - 1; ++i){
        	int parent = sc.nextInt();
        	int child = sc.nextInt();
        	TempNode p = lNodes.get(parent - 1);
        	TempNode c = lNodes.get(child - 1);
        	p.childList.add(c);
        }
        
        sc.close();
        Tree ret = convert(null, lNodes.get(0), 0);
        
        return ret;
    }   
    
    private static Tree convert(TreeNode parent, TempNode node, int depth){
    	Tree ret = null;
    	ArrayList<TempNode> childList = node.childList;
    	Tree tNode = null;
    	if(!childList.isEmpty()){
    		tNode = new TreeNode(node.getValue(), node.getColor(), depth);
    		for(TempNode ct : childList){
    			convert((TreeNode) tNode, ct, depth + 1);
    		}
    	}else{
    		tNode = new TreeLeaf(node.getValue(), node.getColor(), depth);
    	}
    	if(parent != null){
    		parent.addChild(tNode);
    	}else{
    		ret = tNode;
    	}
    	return ret;
    }

    private static Color getColor(int c){
    	if(c == 0){
    		return Color.RED;
    	}else{
    		return Color.GREEN;
    	}
    }
    public static void main(String[] args) {
      	Tree root = solve();
		SumInLeavesVisitor vis1 = new SumInLeavesVisitor();
      	ProductOfRedNodesVisitor vis2 = new ProductOfRedNodesVisitor();
      	FancyVisitor vis3 = new FancyVisitor();

      	root.accept(vis1);
      	root.accept(vis2);
      	root.accept(vis3);

      	int res1 = vis1.getResult();
      	int res2 = vis2.getResult();
      	int res3 = vis3.getResult();

      	System.out.println(res1);
     	System.out.println(res2);
    	System.out.println(res3);
	}
}