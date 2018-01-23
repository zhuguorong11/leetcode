
public class Test2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a = "abc";
		String b = a;
		StringBuilder stringBuilder = new StringBuilder(b);
		stringBuilder.setCharAt(0, 'f');
		System.out.println(a);
		System.out.println(b);
		b = "eeee";
		System.out.println(a);
		System.out.println(b);
		
		Ele aa = new Ele(4);
		Ele bb = aa;
		bb.setNum(10000);
		System.out.println(aa.num);
		System.out.println(bb.num);
		Ele cc = new Ele(908);
		cc = bb;
		cc.setNum(123455);
		System.out.println(aa.num);
		System.out.println(bb.num);
		System.out.println(cc.num);
		Ele dd = (Ele)cc.clone();
		dd.setNum(123123);
		System.out.println(aa.num);
		System.out.println(bb.num);
		System.out.println(cc.num);
		System.out.println(dd.num);
	}

}
class Ele implements Cloneable{
	int num;
	public Ele(){
		
	}
	public Ele(int a){
		this.num = a;
	}
	 public Object clone()    
     {    
         Object o=null;    
        try    
         {    
         o=(Ele)super.clone();//Object 中的clone()识别出你要复制的是哪一个对象。    
         }    
        catch(CloneNotSupportedException e)    
         {    
             System.out.println(e.toString());    
         }    
        return o;    
     }    
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	
}