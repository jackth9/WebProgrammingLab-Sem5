class Book{

    String name;
    String publisher;
    int year;
    int edition;
    double price;

    Book(String n,String p,int y,int e,double pr){
        name=n;
        publisher=p;
        year=y;
        edition=e;
        price=pr;
    }

    void display(){
        System.out.println("Book : "+name);
    }
}

class CollegeBook extends Book{

    String subject;

    CollegeBook(String n,String p,int y,int e,double pr,String s){
        super(n,p,y,e,pr);
        subject=s;
    }
 
    String getName() {
    	return super.name;
    }
    
    @Override
    void display(){
        System.out.print("College Book: ");
        System.out.println(name+" "+subject);
    }

    void syllabus(){
        System.out.println("Used for College");
    }
}

class StoryBook extends Book{

    String genre;

    StoryBook(String n,String p,int y,int e,double pr,String g){
        super(n,p,y,e,pr);
        genre=g;
    }

    String getName() {
    	return super.name;
    }
    @Override
    void display(){
        System.out.print("Story Book: ");
        System.out.println(name+" "+genre);
    }

    void entertainment(){
        System.out.println("For Reading");
    }
}

public class OnlineBookShop {

    public static void main(String args[]){

        Book b1=new CollegeBook("Java","Pearson",2024,5,600,"Programming");
        Book b2=new StoryBook("Harry Potter","Bloomsbury",2007,3,500,"Fantasy");

        b1.display();
        b2.display();


	System.out.println();
	System.out.println("After Downcasting: ");

        CollegeBook cb=(CollegeBook)b1;
        System.out.print(cb.getName());
	System.out.print(" ");
	cb.syllabus();

        StoryBook sb=(StoryBook)b2;
	System.out.print(sb.getName());
	System.out.print(" ");
        sb.entertainment();
    }
}
