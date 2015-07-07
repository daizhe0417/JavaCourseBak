package cn.lntu.t33;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Hashtable;

import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class HUpdate extends JPanel implements ActionListener   
{    
	  Hashtable ��ְ����Ϣ��=null;                              
	  JTextField ��ְ�ߺ�,��ְ������,����רҵ,�Ƿ�Ƹ��,��нҪ��;                    
	  JRadioButton ��,Ů;   
	  ButtonGroup group=null;   
	  JButton ��ʼ�޸�,¼���޸�,����;   
	  FileInputStream inOne=null;   
	  ObjectInputStream inTwo=null;   
	  FileOutputStream outOne=null;   
	  ObjectOutputStream outTwo=null;   
	  File file=null;                                              
	  public HUpdate(File file)   
	  {   
	   this.file=file;   
	   ��ְ�ߺ�=new JTextField(10);   
	   ��ְ������=new JTextField(10);                                   
	   ����רҵ=new JTextField(10);   
	   �Ƿ�Ƹ��=new JTextField(10);   
	   ��нҪ��=new JTextField(10);   
	   group=new ButtonGroup();   
	   ��=new JRadioButton("��",true);   
	   Ů=new JRadioButton("Ů",false);   
	   group.add(��);   
	   group.add(Ů);   
	   ��ʼ�޸�=new JButton("��ʼ�޸�");   
	   ¼���޸�=new JButton("¼���޸�");   
	   ¼���޸�.setEnabled(false);   
	   ����=new JButton("����");   
	   ��ְ�ߺ�.addActionListener(this);   
	   ��ʼ�޸�.addActionListener(this);   
	   ¼���޸�.addActionListener(this);   
	   ����.addActionListener(this);   
	   Box box1=Box.createHorizontalBox();                 
	   box1.add(new JLabel("����Ҫ�޸���Ϣ����ְ�߱��:",JLabel.CENTER));   
	   box1.add(��ְ�ߺ�);   
	   box1.add(��ʼ�޸�);   
	   Box box2=Box.createHorizontalBox();                 
	   box2.add(new JLabel("(��)��ְ������:",JLabel.CENTER));   
	   box2.add(��ְ������);   
	   Box box3=Box.createHorizontalBox();                 
	   box3.add(new JLabel("(��)�Ա�:",JLabel.CENTER));   
	   box3.add(��);   
	   box3.add(Ů);   
	   Box box4=Box.createHorizontalBox();                 
	   box4.add(new JLabel("(��)����רҵ:",JLabel.CENTER));   
	   box4.add(����רҵ);   
	   Box box5=Box.createHorizontalBox();                 
	   box5.add(new JLabel("(��)�Ƿ�Ƹ��:",JLabel.CENTER));   
	   box5.add(�Ƿ�Ƹ��);   
	   Box box6=Box.createHorizontalBox();                 
	   box6.add(new JLabel("(��)��нҪ��/��:",JLabel.CENTER));   
	   box6.add(��нҪ��);   
	   Box boxH=Box.createVerticalBox();                 
	   boxH.add(box1);   
	   boxH.add(box2);   
	   boxH.add(box3);   
	   boxH.add(box4);   
	   boxH.add(box5);   
	   boxH.add(box6);   
	   boxH.add(Box.createVerticalGlue());              
	   JPanel pCenter=new JPanel();   
	   pCenter.add(boxH);   
	   setLayout(new BorderLayout());   
	   add(pCenter,BorderLayout.CENTER);   
	   JPanel pSouth=new JPanel();   
	   pSouth.add(¼���޸�);   
	   pSouth.add(����);   
	   add(pSouth,BorderLayout.SOUTH);   
	   validate();   
	  }   
	 public void actionPerformed(ActionEvent e)   
	 {    
	   if(e.getSource()==��ʼ�޸�||e.getSource()==��ְ�ߺ�)   
	      {   
	         String number="";   
	        number=��ְ�ߺ�.getText();   
	           
	         if(number.length()>0)   
	            {   
	              try {   
	                    inOne=new FileInputStream(file);   
	                    inTwo=new ObjectInputStream(inOne);   
	                    ��ְ����Ϣ��=(Hashtable)inTwo.readObject();   
	                    inOne.close();   
	                    inTwo.close();   
	                  }   
	               catch(Exception ee)   
	                   {   
	                   }   
	              if(��ְ����Ϣ��.containsKey(number))             
	                 {   
	                   ¼���޸�.setEnabled(true);   
	                   Jobhunter stu=(Jobhunter)��ְ����Ϣ��.get(number);   
	                   ��ְ������.setText(stu.getjhname());   
	                   ����רҵ.setText(stu.getgdzy());   
	                   �Ƿ�Ƹ��.setText(stu.getsfpy());   
	                   ��нҪ��.setText(stu.getyxyq());    
	                   if(stu.getsex().equals("��"))   
	                      {   
	                        ��.setSelected(true);   
	                      }   
	                    else   
	                      {   
	                        Ů.setSelected(true);   
	                      }   
	                 }    
	              else   
	                 {    
	                  ¼���޸�.setEnabled(false);   
	                     
	                  String warning="����ְ�߱�Ų�����!";   
	                  JOptionPane.showMessageDialog(this,warning,"����",JOptionPane.WARNING_MESSAGE);   
	                  ��ְ�ߺ�.setText(null);   
	                  ��ְ������.setText(null);   
	           	      ����רҵ.setText(null);   
	         	      �Ƿ�Ƹ��.setText(null);   
	         	      ��нҪ��.setText(null);   
	   
	                 }   
	            }   
	        else   
	            {    
	              ¼���޸�.setEnabled(false);    
	                 
	              String warning="����Ҫ������ְ�߱��!";   
	              JOptionPane.showMessageDialog(this,warning,"����",JOptionPane.WARNING_MESSAGE);   
	              ��ְ�ߺ�.setText(null);   
                  ��ְ������.setText(null);   
           	      ����רҵ.setText(null);   
         	      �Ƿ�Ƹ��.setText(null);   
         	      ��нҪ��.setText(null);   
	            }   
	      }    
	  else if(e.getSource()==¼���޸�)   
	      {    
	        String number="";   
	        number=��ְ�ߺ�.getText();   
	        if(number.length()>0)   
	           {   
	            try {   
	                 inOne=new FileInputStream(file);   
	                 inTwo=new ObjectInputStream(inOne);   
	                 ��ְ����Ϣ��=(Hashtable)inTwo.readObject();   
	                 inOne.close();   
	                 inTwo.close();    
	                }   
	            catch(Exception ee)   
	                {   
	                }   
	            if(��ְ����Ϣ��.containsKey(number))             
	                {   
	                  String question="����ְ����Ϣ�Ѵ���,�����޸���(��)�Ļ�����Ϣ��?";   
	                     
	                  JOptionPane.showMessageDialog(this,question,"����",JOptionPane.QUESTION_MESSAGE);   
	                      
	                  String m="��ְ����Ϣ�����޸�!";   
	                  int ok=JOptionPane.showConfirmDialog(this,m,"ȷ��",JOptionPane.YES_NO_OPTION,   
	                                                 JOptionPane.INFORMATION_MESSAGE);   
	                  if(ok==JOptionPane.YES_OPTION)   
	                    {   
	                	  String name=��ְ������.getText();   
		                  String gdzy=����רҵ.getText();   
		                  String sfpy=�Ƿ�Ƹ��.getText();   
		                  String yxyq=��нҪ��.getText();    
	                      String sex=null;   
	                        if(��.isSelected())   
	                           {   
	                             sex=��.getText();   
	                           }   
	                        else   
	                           {   
	                             sex=Ů.getText();   
	                           }   
	                     Jobhunter  ��ְ��=new Jobhunter();   
	                     ��ְ��.setjhnumber(number);
	                     ��ְ��.setjhname(name);   
	                     ��ְ��.setgdzy(gdzy);   
	                     ��ְ��.setsfpy(sfpy);   
	                     ��ְ��.setyxyq(yxyq);   
	                     ��ְ��.setsex(sex);  
	                     try   
	                      {   
	                       outOne=new FileOutputStream(file);   
	                       outTwo=new ObjectOutputStream(outOne);   
	                       ��ְ����Ϣ��.put(number,��ְ��);   
	                       outTwo.writeObject(��ְ����Ϣ��);   
	                       outTwo.close();   
	                       outOne.close();   
	                       ��ְ�ߺ�.setText(null);   
                           ��ְ������.setText(null);                                   
                           ����רҵ.setText(null);   
                           �Ƿ�Ƹ��.setText(null);   
                           ��нҪ��.setText(null);    
	                      }   
	                     catch(Exception ee)   
	                      {    
	                       System.out.println(ee);   
	                      }   
	                     ¼���޸�.setEnabled(false);    
	                   }   
	                 else if(ok==JOptionPane.NO_OPTION)   
	                   {   
	                     ¼���޸�.setEnabled(true);   
	                   }   
	               }   
	             else   
	               {   
	                   
	                 String warning="����ְ�߱��û����ְ����Ϣ,�����޸�!";   
	                 JOptionPane.showMessageDialog(this,warning,"����",JOptionPane.WARNING_MESSAGE);   
	                 ¼���޸�.setEnabled(false);    
	               }   
	           }   
	        else   
	           {   
	              String warning="����Ҫ������ְ�߱��!";   
	              JOptionPane.showMessageDialog(this,warning,"����",JOptionPane.WARNING_MESSAGE);   
	              ¼���޸�.setEnabled(false);   
	           }   
	       }   
	   if(e.getSource()==����)   
	      {    
		   ��ְ�ߺ�.setText(null);   
           ��ְ������.setText(null);                                   
           ����רҵ.setText(null);   
           �Ƿ�Ƹ��.setText(null);   
           ��нҪ��.setText(null);    
	      }   
	  }   
	}   
