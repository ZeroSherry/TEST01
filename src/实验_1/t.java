package ʵ��_1;
import java.util.Random;
public class t{
	public static void main(String[] args) {
		short[] x=new short[50]; 
		short[] y=new short[50];
		short[] ov=new short[50];//�����
		printHeader();              //��˵������������ú�ʹ��
		printExercise(x,y,ov);  //������ʽ
		printCalculations(x,y,ov);  //���ɴ�
	}
		public static void printHeader() {
			System.out.println("****************************************************************************************");
			System.out.println("-�������50��100���ڵļӼ�����ʽϰ��-");
			System.out.println("-ÿ�����г���ɵõ�һ��50�����ϰ���-");
			System.out.println("****************************************************************************************");
		}
		public static void printCalculations(short[] x,short[] y,short[] ov) {
			System.out.println("****************************************************************************************");
			System.out.println("-������ϰ��Ĳο���-");
			System.out.println("****************************************************************************************");
			for(int i=0;i<50;i++) {
				if(ov[i]==1) {
					int answer=x[i]+y[i];
					System.out.print("("+(i+1)+")"+":   "+answer+"\t");
					if((i+1)%5==0) {
						System.out.println();
					}		
				}
				else {
					int answer=x[i]-y[i];
					System.out.print("("+(i+1)+")"+":   "+answer+"\t");
					if((i+1)%5==0) {
						System.out.println();
					}	
					
				}
			}
		}
		public static void printExercise(short[] x,short[] y,short[] ov) {
				char o='+';
				Random random=new Random();
				for(int i=0;i<50;i++) {
					ov[i]=(short)random.nextInt(2);
					if((ov[i])==1) {
						while(true){
							short index1=(short)random.nextInt(101);
							short index2=(short)random.nextInt(101);
							if(index1+index2<=100) {
								x[i]=index1;
								y[i]=index2;
								break;//�жϺͲ��ܳ���һ��
							}	
						}
						o='+';
					}
					else {
						while(true){
							short index1=(short)random.nextInt(101);
							short index2=(short)random.nextInt(101);
							if(index1-index2>0) {
								x[i]=index1;
								y[i]=index2;
								break;//�жϲ��С����
							}	
						}
						o='-';
					}
					for(int m=0;m<49;m++) {
						for(int n=m+1;n<50;n++) {
							if(x[m]==x[n]&&y[m]==y[n]&&ov[m]==ov[n]||ov[m]==1&&x[m]==y[n]&&y[m]==x[n]) {
								x[m]=(short)random.nextInt(101);
								y[m]=(short)random.nextInt(101);
								ov[m]=(short)random.nextInt(2);
								m=0;
								break;
							}
						}	
					}//�ж��ظ�
					System.out.print("("+(i+1)+")"+":  "+x[i]+o+y[i]+"="+"\t");
					if((i+1)%5==0)
						System.out.println();
				}
			}
		}