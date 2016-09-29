package com.java.tree;

import java.util.Stack;

public class BinaryTree<T>{
	private class TreeNode<T>{
		private int key=0;
		private T data=null;
		private boolean isVisted=false;
		private TreeNode leftChild=null;
		private TreeNode rightChild=null;
		
		public TreeNode(){}
		
	/*	public TreeNode(int key,T data){
			this.key=key;
			this.data = data;
			this.leftChild=null;
			this.rightChild=null;
		}*/
		
		public void displayNode(){
			System.out.println('{');
			System.out.println(key);
			System.out.println(',');
			System.out.println(data);
			System.out.println("} ");
		}
	}
	
	private TreeNode<T> root;
	
	public BinaryTree(){
		root=null;
	}
	
	public boolean isEmpty(){
		return root==null;
	}
	
	private int height(TreeNode<T> subTree){
		if(subTree==null)
			return 0;
		else{
			int i=height(subTree.leftChild);
			int j=height(subTree.rightChild);
			return (i<j)?(j+1):(i+1);
		}
	}
	
	private int size(TreeNode<T> subTree){
		if(subTree==null){
			return 0;
		}else{
			return 1+size(subTree.leftChild)+size(subTree.rightChild);
		}
	}
	
	public int height(){
		return height(root);
	}
	
	public int size(){
		return size(root);
	}
	
	public void insert(int key,T data){
		TreeNode newNode = new TreeNode();
		newNode.key = key;
		newNode.data = data;
		
		if(root==null){
			root = newNode;
		}else{
			TreeNode current=root;
			TreeNode parent;
			while(true){
				parent=current;
				if(key<parent.key){
					current = current.leftChild;
					if(current==null){
						parent.leftChild = newNode;
						return;
					}
				}else{
					current = current.rightChild;
					if(current==null){
						parent.rightChild = newNode;
						return;
					}
				}
			}
		}
		
		
	}
	
	public void visted(TreeNode<T> subTree){  
        subTree.isVisted=true;  
        System.out.println("key:"+subTree.key+"--name:"+subTree.data);;  
    } 
	
	public TreeNode<T> parent(TreeNode<T> element){
		return (root==null||root==element)?null:parent(root,element);
	}
	
	public TreeNode<T> parent(TreeNode<T> subTree,TreeNode<T> element){
		if(subTree==null)
			return null;
		if(subTree.leftChild == element || subTree.rightChild == element){
			return subTree;
		}
		
		TreeNode p;
		
		if((p=parent(subTree.leftChild,element))!=null)
			return p;
		else
			return parent(subTree.rightChild,element);
	}
	
	public TreeNode<T> getLeftChildNode(TreeNode<T> element){
		return (element!=null)?element.leftChild:null;
	}
	
	public TreeNode<T> getRightChildNode(TreeNode<T> element){
		return (element!=null)?element.rightChild:null;
	}
	
	public TreeNode getRoot(){
		return root;
	}
	
	public void destroy(TreeNode<T> subTree){
		if(subTree!=null){
			destroy(subTree.leftChild);
			destroy(subTree.rightChild);
			subTree=null;
		}
	}
	
	public void traverse(TreeNode subTree){
		System.out.println("key:"+subTree.key+" data:"+subTree.data);
		traverse(subTree.leftChild);
		traverse(subTree.rightChild);
	}
	
	public void preOrder(TreeNode subTree){
		if(subTree!=null){
			visted(subTree);
			preOrder(subTree.leftChild);
			preOrder(subTree.rightChild);
		}
	}
	
	public void inOrder(TreeNode subTree){
		if(subTree!=null){
			inOrder(subTree.leftChild);
			visted(subTree);
			inOrder(subTree.rightChild);
		}
	}
	
	public void postOrder(TreeNode subTree){
		if(subTree!=null){
			postOrder(subTree.leftChild);
			postOrder(subTree.rightChild);
			visted(subTree);
		}
	}
	
	
	 //前序遍历的非递归实现  
    public void nonRecPreOrder(TreeNode p){  
        Stack<TreeNode> stack=new Stack<TreeNode>();  
        TreeNode node=p;  
        while(node!=null||stack.size()>0){  
        	if(node!=null){  
        				 //root
                 visted(node);
                 //将子树压栈  
                 stack.push(node);  
                 node=node.leftChild;  
             }else{  
                 node=stack.pop();  
                 node=node.rightChild;  
             }   
        }  
    }  
    
  //中序遍历的非递归实现  
    public void nonRecInOrder(TreeNode p){  
        Stack<TreeNode> stack =new Stack<BinaryTree.TreeNode>();  
        TreeNode node =p;  
        while(node!=null||stack.size()>0){  
            //存在左子树  
            if(node!=null){  
                stack.push(node);  
                node=node.leftChild;  
            }else{  
                node=stack.pop();  
                visted(node);  
                node=node.rightChild;  
            }  
        }  
    }  
      
    //后序遍历的非递归实现  
    public void nonRecPostOrder(TreeNode p){  
        Stack<TreeNode> stack=new Stack<BinaryTree.TreeNode>();  
        TreeNode node =p;  
        while(p!=null){  
            //左子树入栈  
            for(;p.leftChild!=null;p=p.leftChild){  
                stack.push(p);  
            }  
            //当前结点无右子树或右子树已经输出  
            while(p!=null&&(p.rightChild==null||p.rightChild==node)){  
                visted(p);  
                //纪录上一个已输出结点  
                node =p;  
                if(stack.empty())  
                    return;  
                p=stack.pop();  
            }  
            //处理右子树  
            stack.push(p);  
            p=p.rightChild;  
        } 
        
       
    }
    
    public void displayTree(){
    	Stack globalStack =new Stack();
    	globalStack.push(root);
    	int nBlanks =32;
    	boolean isRowEmpty = false;
    	System.out.println("--------------------------------------");
    	while(isRowEmpty==false){
    		Stack localStack = new Stack();
    		isRowEmpty = true;
    		
    		for(int j =0;j<nBlanks;j++)
    			System.out.print(' ');
    		
    		while(globalStack.isEmpty()==false){
    			TreeNode temp = (TreeNode) globalStack.pop();
    			if(temp !=null){
    				System.out.print(temp.data);
    				localStack.push(temp.leftChild);
    				localStack.push(temp.rightChild);
    				
    				if(temp.leftChild!=null||temp.rightChild!=null)
    					isRowEmpty =false;
    				else{
    					System.out.print("--");
    					localStack.push(null);
    					localStack.push(null);
    				}
    				for(int j=0;j<nBlanks*2-2;j++)
    					System.out.print(' ');
    			}
    			System.out.println();
    			nBlanks /=2;
    			while(localStack.isEmpty()==false)
    				globalStack.push(localStack.pop());
    		}
    		System.out.println("-------------------------------------------------");
    	}
    }
    
    public static void main(String[] args) {
		 BinaryTree<Double> tree = new BinaryTree<Double>();
		 tree.insert(50, 1.5);
		 tree.insert(25, 1.2);
		 tree.insert(75, 1.7);
		 tree.insert(12, 1.8);
		 tree.insert(37, 1.2);
		 tree.insert(43, 2.1);
		 tree.insert(30, 1.9);
		 tree.insert(33, 1.1);
		 tree.insert(87, 0.9);
		 tree.insert(93, 1.4);
		 tree.insert(97, 1.6); 
		// tree.traverse(tree.root);
		// tree.displayTree(); 
		 tree.postOrder(tree.root);
		// tree.preOrder(tree.root);
		// tree.inOrder(tree.root);
		 System.out.println("--------------");
		// tree.nonRecInOrder(tree.root);
		// tree.nonRecPreOrder(tree.root);
		 tree.nonRecPostOrder(tree.root);
		// tree.nonRecInOrder(tree.root);
		 /*
		  * 				1.5
		  * 			1.2
		  * 
		  * 
		  */
		
	}
	
}
