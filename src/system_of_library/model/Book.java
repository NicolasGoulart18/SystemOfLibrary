package system_of_library.model;

public class Book {
     private static int contador=1;
     private int id;
     private String title;
     private String author;
     private int releaseyear;
     private boolean available;

    public Book(String title, String author, int releaseyear){
        this.id=contador;
        contador++;
        this.title = title;
        this.author = author;
        setReleaseyear(releaseyear);
        available =true;

    }



    public int getId(){
        return id;
    }

     public String getTitle(){

        return title;
    }

    public void setTitle(String title){
        if(title==null || title.isBlank()){
            System.out.println("Titulo inválido!");
        }else{
            this.title = title;
        }
    }


    public String getAuthor(){
        return author;
    }

    public void setAuthor(String author){
        if(author == null || author.isBlank()){
            System.out.println("Autor inválido!");
        }else{
            this.author=author;
        }
    }

    public int getReleaseyear(){

        return releaseyear;
    }

    public void setReleaseyear(int releaseyear){
        if(releaseyear <=0){
            System.out.println("ERRO: "+ getTitle()+" com data inválido");
        }else{
            this.releaseyear = releaseyear;
        }

    }

    //get do boolean
    public boolean isAvailable() {
        return available;
    }


    public boolean emprestarLivro(){
        if(isAvailable()){
            available=false;
            return true;
        }
        return false;
    }

    public boolean devolverLivro(){
        if(!isAvailable()){
            available=true;
            return true;
        }
        return false;
    }

}
