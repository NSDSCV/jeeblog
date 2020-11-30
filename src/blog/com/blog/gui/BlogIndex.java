package blog.com.blog.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JLabel;

public class BlogIndex {

	private JFrame frmBlog;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BlogIndex window = new BlogIndex();
					window.frmBlog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public BlogIndex() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmBlog = new JFrame();
		frmBlog.setTitle("Blog");
		frmBlog.setBounds(100, 100, 721, 610);
		frmBlog.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmBlog.getContentPane().setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(150, 67, 443, 322);
		frmBlog.getContentPane().add(textArea);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBounds(150, 451, 443, 91);
		frmBlog.getContentPane().add(textArea_1);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(316, 415, 138, 26);
		frmBlog.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(331, 42, 54, 15);
		frmBlog.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBounds(537, 43, 54, 15);
		frmBlog.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setBounds(10, 10, 54, 15);
		frmBlog.getContentPane().add(lblNewLabel_3);
	}
}
