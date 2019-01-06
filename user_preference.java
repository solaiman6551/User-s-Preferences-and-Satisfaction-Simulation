import java.util.Scanner;
 
class user_preference
{
   public static void main(String args[])
   {
      int x = 1, y = 3;
      int p, q;
      Scanner in = new Scanner(System.in);
 
     // System.out.println("number of rows and columns");
     // x = in.nextInt();
     // y  = in.nextInt();
 
      double first[][] = new double[x][y];
      double second[][] = new double[x][y];
      double third[][] = new double[x][y];
      
      //similarity starts
      double product1[][] = new double[x][y];
      double sqr1[][] = new double[x][y];
      double sqr2[][] = new double[x][y];
      double sum1 = 0;
      double sum2 = 0;
      double sum3 = 0;
      double sum4 = 0;
      double sum5 = 0;
      //similarity ends
      
      //utility starts
      double sub1[][] = new double[x][y];
      double del1[][] = new double[x][y];
      double sum_utility[][] = new double[x][y];
      double smallest = 100.00;
      double largest = 0.00;
      double result_utility = 0;
      //utility ends
      
      //satisfaction starts
      double sub1st[][] = new double[x][y];
      double product1st[][] = new double[x][y];
      double div1[][] = new double[x][y];
      double sum1st=0;
      double sat_result;
      //satisfaction ends

   
      
      System.out.println("first matrix: Demand (d)");
      for (p=0;p<x;p++)
         for(q=0;q<y;q++ )
            first[p][q]=in.nextDouble();
 
      System.out.println("second matrix: Resource Capability (w)");
      for (p=0;p<x;p++ )
         for (q=0;q<y;q++)
            second[p][q]=in.nextDouble();
      
      System.out.println("third matrix: Weight Of Demand (q)");
      for (p=0;p<x;p++ )
         for (q=0;q<y;q++)
            third[p][q]=in.nextDouble();
      
      
      
      //------similarity code starts-------
      //product
      for (p=0;p<x;p++)
         for(q=0;q<y;q++)
             product1[p][q]=(first[p][q]*second[p][q]);
      //sum of product 
      for (p=0;p<x;p++)
          for(q=0;q<y;q++)
              sum1+=product1[p][q];  
      
      
      //square of first matrix
      for (p=0;p<x;p++)
         for(q=0;q<y;q++)
             sqr1[p][q]=(first[p][q]*first[p][q]);
      //sum of square for first matrix
      for (p=0;p<x;p++)
          for(q=0;q<y;q++)
              sum2+=sqr1[p][q]; 
      
      
      
      //square of second matrix
      for (p=0;p<x;p++)
         for(q=0;q<y;q++)
             sqr2[p][q]=(second[p][q]*second[p][q]);    
      //sum of square for second matrix
      for (p=0;p<x;p++)
          for(q=0;q<y;q++)
              sum3+=sqr2[p][q];  
     
      
      sum4=Math.sqrt(sum2*sum3); 
      sum5 = (sum1/sum4);
      
      //-----similarity code ends---------
      
      
      //-----utility code starts------
      //subtraction w-d
      for (p=0;p<x;p++)
         for(q=0;q<y;q++)
             sub1[p][q]=Math.abs(second[p][q]-first[p][q]);
 
      //min 
        for (p=0;p<x;p++)
    	  for(q=0;q<y;q++)
        if(sub1[p][q]<smallest) 
        {
        	smallest = sub1[p][q];
        }
        
        //max
        for (p=0;p<x;p++)
      	  for(q=0;q<y;q++)
         if(sub1[p][q]>largest)
        {
        	largest = sub1[p][q];
        }
        
        //finding the value of del
        for (p=0;p<x;p++)
        	  for(q=0;q<y;q++)
        		  if(second[p][q]-first[p][q]>0)
        		  {
        			del1[p][q]=(second[p][q]-first[p][q]);
        		  }
        		  else if(second[p][q]-first[p][q]<0)
        		  {
        			  del1[p][q]=(Math.abs(second[p][q]-first[p][q])+largest);
        		  }
        		  else if((second[p][q]-first[p][q])==0)
        		  {
        			  del1[p][q]=smallest;
        		  }
        
         //finding the summation of total reuslt
         for (p=0;p<x;p++)
      	      for(q=0;q<y;q++)
                 sum_utility[p][q] = (third[p][q]/del1[p][q]);
         
         for (p=0;p<x;p++)
     	      for(q=0;q<y;q++)
                 result_utility += sum_utility[p][q];
         
         //------utility code ends------
         
         //------satisfaction code starts------
         
         //subtraction w-d
         for (p=0;p<x;p++)
            for(q=0;q<y;q++)
                sub1st[p][q]=Math.abs(second[p][q]-first[p][q]);
         //product of sub1 
         for (p=0;p<x;p++)
             for(q=0;q<y;q++)
                 product1st[p][q]=(sub1st[p][q]*third[p][q]);
         //div
         for (p=0;p<x;p++)
       	  for (q=0;q<y;q++)
       		  div1[p][q] = (product1st[p][q]/first[p][q]);
         //summation of the matrix
         for (p=0;p<x;p++)
       	  for (q=0;q<y;q++)
       		  sum1st += div1[p][q]; 
         
         sat_result = (1-(1.00/3.00)*sum1st); 
         
         //------satisfaction code ends------
         
         
      //****print result*****
       
      System.out.println("Final Result");
      System.out.println("Similarity:");
      System.out.println(sum5+"\t");
      System.out.println("Utility:");
      System.out.println(result_utility+"\t");
      System.out.println("Satisfaction:");
      System.out.print(sat_result+"\t");
      
     }
   }
