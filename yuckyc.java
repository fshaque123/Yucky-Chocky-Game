import javax.swing.*;
import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;



public class yuckyc {
	
	public static JFrame frame= new JFrame("YUCKY CHOCKY");
	public static Color mycol=new Color(140,140,140);
	public static Color myblue=new Color(153,204,255);
	public static Color choc=new Color(102,51,0);
	public static Color soap=new Color(102,255,153);

	public static JPanel panel= new JPanel();
	public static JPanel panel2 = new JPanel();
	public static JPanel panel3=new JPanel();
	public static JPanel panel4 = new JPanel();

	public static Random random=new Random();

	public static JButton[][] t =new JButton[0][0];

	public static Object o;
	public static Object selected;
	
	public static int compr;
	public static int compc;

	public static int r1;
	public static int c1;
	
	public static JLabel win;
	
	public static JLabel turn;
	public static Boolean replay=false;
	
	static void playgame(int w, int h)throws InterruptedException {  
		
		
		
		panel4.setBackground(mycol);
		panel4.setPreferredSize(new Dimension (1000,1000));
		
		panel3.setBackground(mycol);
		panel3.setPreferredSize(new Dimension (1000,1000));

		
		panel2.setBackground(mycol);
		panel2.setPreferredSize(new Dimension (1000,1000));
		
		t =new JButton[w][h];
		panel2.setLayout(new GridLayout(w+1,h,1,1));
		
	
			for(int r=0;r<w;r++) {
				for(int c=0;c<h;c++) {
				    
					t[r][c]=new JButton();
					t[r][c].setBackground(choc);
					t[r][c].setOpaque(true);
					t[r][c].setBorderPainted(false);
				
					panel2.add(t[r][c]);
					int row=r;
					int column=c;
					if(row==0&&column==0) {
						t[0][0].setBackground(soap);
						t[0][0].setOpaque(true);
						t[0][0].setBorderPainted(false);
			
					}
	

				}
	
			}
			t[0][0].setEnabled(false);
		
			int loser=0;
			int player=1;
			int count=0;
		
				
	
				if(player==1) {
					turn=new JLabel("Your turn");
					panel2.add(turn);
				}
				else if (player==2) {
					turn=new JLabel("Computer's turn");
					panel2.add(turn);
				}
				frame.add(panel2);
				frame.pack();
				frame.setVisible(true);
				
				
				Object startButton=getLegalMove(player,w,h,t);
				
			
		
       }
	
	
	
	static void initialise()throws InterruptedException {  
		
		frame.setSize(1000,1000);
		
		panel.setBackground(mycol);
		panel.setPreferredSize(new Dimension (1000,1000));
		
		//buttons//
		
		JButton bt1=new JButton("3x3");
		
		JButton bt2=new JButton("4x4");
		
		JButton bt3=new JButton("5x5");
		
		//labels//
		JLabel greet= new JLabel("Let's play Yuckychocky!");
		JLabel option=new JLabel("Choose the size of your chocolate bar to start eating: ");
        
		
		bt1.setBackground(myblue);
		bt2.setBackground(myblue);
		bt3.setBackground(myblue);
		
		
	    bt1.setOpaque(true);
		bt1.setBorderPainted(false);
		
	
	    bt2.setOpaque(true);
		bt2.setBorderPainted(false);
		
	
	    bt3.setOpaque(true);
		bt3.setBorderPainted(false);
		
		//locations//
		bt1.setLocation(10,10);
		bt2.setLocation(20,20);
		bt3.setLocation(30,30);
		
		
		//adding stuff to panel//
		panel.setLayout(new GridLayout(5,2,10,10));
		panel.add(greet);
		panel.add(option);
		panel.add(bt1);
		panel.add(bt2);
		panel.add(bt3);
	
		frame.add(panel);
		frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//actionlisteners//
		bt1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				     frame.remove(panel);
				     try {
						playgame(3, 3);
					} catch (InterruptedException e1) {
						
						e1.printStackTrace();
					}
				   
				     
			}
			
		});
		bt2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 
				     frame.remove(panel);
				     try {
						playgame(4, 4);
					} catch (InterruptedException e1) {
						
						e1.printStackTrace();
					}
			}
		});
		
		bt3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			     frame.remove(panel);
			      try {
					playgame(5, 5);
				} catch (InterruptedException e1) {
					
					e1.printStackTrace();
				}
			}
		});
		
		
        
	}
	
	public static int changeplayer(int p) {
		if(p==1) {
			p=2;
			
		}
		else if(p==2) {
			p=1;
		
		
		}
		return p;
	}
	
	
	
	public static Object getLegalMove(int player,int w, int h,JButton t[][])throws InterruptedException {  
		       
     
		       
			   for(int r=0;r<w;r++) {
				   for(int c=0;c<h;c++) {
				
							  t[0][0].setEnabled(false);  
				
								t[r][c].addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent e) {
										   
		                                   o=e.getSource();
								           selected=o;
								           
								           
								           for(int r=0; r<w;r++) {
								        	   for(int c=0; c<h;c++) {
								        		   
								        		   if(t[r][c]==selected) {
								        			  
								        		if(r==0) {
								        		   eat(selected,t,player,w,h);
								        		
								        		   compMove(r,c,player,t,w,h);
								        		   }
					
					   if(c==0) {
		                                   
								           
								       
								           
											
												eat(selected,t,player,w,h);
												
												compMove(r,c,player,t,w,h);
		                                		   }
		                    //if c==0
					   
					  
					   
					   
					   
					   
					   
					   
					   
				   } // for c ends
			   } //for r ends
								           }
									}
								});
				   }
			   }
			   
		 return o;


	}
	
	static void eat(Object selected,JButton t[][],int player,int w,int h) {  
		       
        
			   for(int r=0;r<w;r++) {
				   for(int c=0;c<h;c++) {
					   
					    if(t[r][c]==selected) {
					    	c1=c;
					    	if(c==h-1 && r!=0) {
					    		c=0;
					    	}
					    	
					    	
					    	r1=r;
					    	for (c=c; c<h; c++) {
								r=r1;
								t[r][c].setEnabled(false);
								t[r][c].setVisible(false);
						
						
								for(r=r1; r<w; r++) {
									t[r][c].setEnabled(false);
									t[r][c].setVisible(false);
								          } 
						
							           }
							
					               }
		    
					    
					    
		                       }
		                   }
			    int count=0;
			    for(int r=0;r<w;r++) {
					   for(int c=0;c<h;c++) {
						   if(t[r][c].isEnabled()==false) {
							   count++;
						   }
					   }
			    }
			    if(count== (w*h)-1) {
			    	frame.remove(panel2);
			    	win=new JLabel("Computer wins!");
			    	panel3.add(win);
			    	frame.add(panel3);
			    	frame.pack();
			    	frame.setVisible(true);


			    	new java.util.Timer().schedule(
					new java.util.TimerTask() {
					@Override	
					public void run() {
						try {
							boolean playgame=play();
						} catch (InterruptedException e) {
							
							e.printStackTrace();
						}							
				
				  
					
					}
					},1500
					
					);
			    	
			     

			    }
			    	
			    
			  
			   
			   
         
		
	}
	
    static void compMove(int cr,int cc,int player,JButton t[][],int w, int h) {
       
    	player=2;
		
		
    	 
    	   
    	if(cr==0) {
			cr=1;
		}
		if(cc==0) {
			cc=1;
		}
		if(cr!=0 && cc!=0) {
			 compr= random.nextInt(cr);
			 compc= random.nextInt(cc);
		}
		
		while(compr==0 && compc== 0) {
			compr= random.nextInt(cr);
			 compc= random.nextInt(cc);
			
		}
		 
			

			 
			 turn.setText("Computer selected ("+ compr +","+compc+"). Your Turn!");
			 
			 
			 for(int r=compr; r<w; r++) {
				for (int c=compc; c< h; c++) {
					
						if(r==0) {
							c1=c;
					    	if(c==h-1 && r!=0) {
					    		c=0;
					    	}
					    	
					    	
					    	r1=r;
					    	for (c=c; c<h; c++) {
								r=r1;
								t[r][c].setEnabled(false);
								t[r][c].setVisible(false);
						
						
								for(r=r1; r<w; r++) {
									t[r][c].setEnabled(false);
									t[r][c].setVisible(false);
								          } 
						
							           }
							return;
				
				
						}
						
						
						/*if(j== col1-1) {
							c1=c;
					    	if(c==h-1 && r!=0) {
					    		c=0;
					    	}
					    	
					    	
					    	r1=r;
					    	for (c=c; c<h; c++) {
								r=r1;
								t[r][c].setEnabled(false);
								t[r][c].setVisible(false);
						
						
								for(r=r1; r<w; r++) {
									t[r][c].setEnabled(false);
									t[r][c].setVisible(false);
								          } 
						
							           }
							return;
						}*/
						if (c==0) {
							c1=c;
					    	if(c==h-1 && r!=0) {
					    		c=0;
					    	}
					    	
					    	
					    	r1=r;
					    	for (c=c; c<h; c++) {
								r=r1;
								t[r][c].setEnabled(false);
								t[r][c].setVisible(false);
						
						
								for(r=r1; r<w; r++) {
									t[r][c].setEnabled(false);
									t[r][c].setVisible(false);
								          } 
						
							           }
							return;
				
						}
						/*if(i== row1-1) {

							c1=c;
					    	if(c==h-1 && r!=0) {
					    		c=0;
					    	}
					    	
					    	
					    	r1=r;
					    	for (c=c; c<h; c++) {
								r=r1;
								t[r][c].setEnabled(false);
								t[r][c].setVisible(false);
						
						
								for(r=r1; r<w; r++) {
									t[r][c].setEnabled(false);
									t[r][c].setVisible(false);
								          } 
						
							           }
						}*/
						
						
					}
		
	
				}
		    int count=0;
		    for(int r=0;r<w;r++) {
				   for(int c=0;c<h;c++) {
					   if(t[r][c].isEnabled()==false) {
						   count++;
					   }
				   }
		    }
		    if(count== w*h) {
		    	frame.remove(panel2);
		    	win=new JLabel("You win!");
		    	panel3.add(win);
		    	frame.add(panel3);
		    	frame.pack();
		    	frame.setVisible(true);
		    	new java.util.Timer().schedule(
						new java.util.TimerTask() {
						@Override	
						public void run() {
							try {
								boolean playgame=play();
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}								
															
					    
						}
						},2000
						);
		    	


		       }
	
			 
				
			}
    	  
    public static boolean play() throws InterruptedException {
        frame.remove(panel3);
       
        
    	JButton yes= new JButton("Yes");
    	JButton no= new JButton("No");
    	
    	JLabel pa=new JLabel("Would you like to play again?");
    	panel4.add(pa);
    	panel4.add(yes);
    	panel4.add(no);
        frame.add(panel4);
        frame.pack();
        frame.setVisible(true);
    	new java.util.Timer().schedule(
				new java.util.TimerTask() {
				@Override	
				public void run() {
											
	
				}
				},2000
				);
		yes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				     replay=true;
				     
				     
				     
				  
				     
			}
		});
		
		no.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				     replay=false;
				    
				   
				     
			}
		});

		if(replay==true) {
			frame.dispose();
			Object o;
			Object selected;
			
			int compr;
			int compc;

			int r1;
			int c1;
			
			main(null);
			
			
		}
		if(replay==false) {
			
		}
		
	
		

    
    	return replay;
    	
    }
	               
    
    
	
 
  
	public static void main(String[] args) throws InterruptedException {
		    initialise();
		    


		  
			
		}
		
	     
	
	} 


