package test

//public class test.User {
//
//    @Nullable
//    private String firstName;
//    @Nullable
//    private String lastName;
//
//    public test.User(String firstName, String lastName) {
//        this.firstName = firstName;
//        this.lastName = lastName;
//    }
//
//    public String getFirstName() {
//        return firstName;
//    }
//
//    public void setFirstName(String firstName) {
//        this.firstName = firstName;
//    }
//
//    public String getLastName() {
//        return lastName;
//    }
//
//    public void setLastName(String lastName) {
//        this.lastName = lastName;
//    }
//
//}
//data class test.User(var firstName: String?, var lastName: String?)
public data class User(var firstName: String? = null, var lastName: String?)

fun main() {
    var user = User("john", "voy")
    println("test.User is ${user.firstName} ${user.lastName}")

    user = User(lastName = "voyatzis")
    val fname = user.firstName ?: "unknown"
    print("test.User is $fname  ${user.lastName}")
}
