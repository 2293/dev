package ml2293.swing;

import javax.swing.*;
import javax.swing.tree.*;
 
public class JTreeDemo1 {
 
  public static void main(String[] arguments) {
 
    JFrame.setDefaultLookAndFeelDecorated(true);
    JFrame frame = new JFrame("JTree Example");
    frame.setSize(300,300);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
 
    DefaultMutableTreeNode books = new DefaultMutableTreeNode("Books");
 
    // Three Departments
    DefaultMutableTreeNode fiction = new DefaultMutableTreeNode("Fiction");
    DefaultMutableTreeNode nonfiction = new DefaultMutableTreeNode("Non-Fiction");
    DefaultMutableTreeNode biography = new DefaultMutableTreeNode("Biography");
 
 
    // Fiction Books
    fiction.add(new DefaultMutableTreeNode("Moby Dick"));
    fiction.add(new DefaultMutableTreeNode("MacBeth"));
    fiction.add(new DefaultMutableTreeNode("War and Peace"));
 
 
    // Non Fiction Books
    nonfiction.add(new DefaultMutableTreeNode("Unbroken"));
    nonfiction.add(new DefaultMutableTreeNode("The Diary of a Young Girl"));
    nonfiction.add(new DefaultMutableTreeNode("The Prince"));
 
    // Biography Books
    biography.add(new DefaultMutableTreeNode("John Adams"));
    biography.add(new DefaultMutableTreeNode("Steve Jobs"));
 
    books.add(fiction);
    books.add(nonfiction);
    books.add(biography);
 
    JTree tree = new JTree(books);
    frame.add(tree);
 
    frame.setVisible(true);
 
  }
}