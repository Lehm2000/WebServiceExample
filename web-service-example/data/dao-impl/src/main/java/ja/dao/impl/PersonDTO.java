package ja.dao.impl;

public class PersonDTO {
   private int id;
   private String firstName; 
   private String lastName;   
   private int age;  

   public PersonDTO() {}
   public PersonDTO(String fname, String lname, int age) {
      this.firstName = fname;
      this.lastName = lname;
      this.age = age;
   }
   public int getId() {
      return id;
   }
   public void setId( int id ) {
      this.id = id;
   }
   public String getFirstName() {
      return firstName;
   }
   public void setFirstName( String first_name ) {
      this.firstName = first_name;
   }
   public String getLastName() {
      return lastName;
   }
   public void setLastName( String last_name ) {
      this.lastName = last_name;
   }
   public int getAge() {
      return age;
   }
   public void setAge( int age ) {
      this.age = age;
   }
}
