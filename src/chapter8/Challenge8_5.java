package chapter8;

import java.util.Hashtable;

/**
 * Created by asus on 8/26/17.
 * Design data structures for an online activeBook reader system.
 * Assume:
 * - user membership creation and extension
 * - searching the database for books
 * - reading a activeBook
 * - only one active user at a time
 * - only one active activeBook by this user
 */
class OnlineReaderSystem{
    private Library library;
    private UserManager userManager;
    private Display display;
    private Book activeBook;
    private LibraryUser activeUser;

    public OnlineReaderSystem() {
        userManager = new UserManager();
        library = new Library();
        display = new Display();
    }

    public Display getDisplay() {
        return display;
    }

    public Library getLibrary() {
        return library;
    }

    public UserManager getUserManager() {
        return userManager;
    }

    public Book getActiveBook() {
        return activeBook;
    }

    public void setActiveBook(Book activeBook) {
        this.activeBook = activeBook;
        display.dispalyBook(activeBook);
    }

    public LibraryUser getActiveUser() {
        return activeUser;
    }

    public void setActiveUser(LibraryUser activeUser) {
        this.activeUser = activeUser;
        display.displayUser(activeUser);
    }
}

class UserManager{
    private Hashtable<Integer, LibraryUser> users;

    public LibraryUser addUser(int id, String details, int accountType){
        if (users.containsKey(id)) return null;
        LibraryUser user = new LibraryUser(id, details, accountType);
        users.put(id, user);
        return user;
    }

    public boolean remove(LibraryUser user){
        return remove(user.getID());
    }

    public boolean remove(int id){
        if (!users.containsKey(id)) return false;
        users.remove(id);
        return true;
    }

    public LibraryUser find(int id){
        return users.get(id);
    }
}
class Library{
    private Hashtable<Integer, Book> books;

    public Book addBook(int id, String details){
        if (books.contains(id)) return null;
        Book book = new Book(id, details);
        books.put(id, book);
        return book;
    }

    public boolean remove(Book b){
        return remove(b.getID());
    }

    public boolean remove(int id){
        if (!books.containsKey(id)) return false;
        books.remove(id);
        return true;
    }

    public Book find(int id){
        return books.get(id);
    }
}

class Display{
    private Book activeBook;
    private LibraryUser activeUser;
    private int pageNumber = 0;

    public void displayUser(LibraryUser user){
        activeUser = user;
        refreshUsername();
    }

    public void dispalyBook(Book book){
        pageNumber = 0;
        activeBook = book;
        refreshTitle();
        refreshDetails();
        refreshPage();
    }

    public void turnPageForward(){
        pageNumber++;
        refreshPage();
    }

    public void turnPageBackward(){
        pageNumber--;
        refreshPage();
    }

    public void refreshUsername(){}
    public void refreshTitle(){}
    public void refreshDetails(){}
    public void refreshPage(){}
}

class Book{
    private int bookId;
    private String details;

    public Book(int id, String det){
        bookId = id;
        details = det;
    }

    public int getID() {
        return bookId;
    }

    public void setID(int bookId) {
        this.bookId = bookId;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}

class LibraryUser{
    private int userId;
    private String details;
    private int accountType;

    public LibraryUser(int userId, String details, int accountType) {
        this.userId = userId;
        this.details = details;
        this.accountType = accountType;
    }

    public void renewMemebership(){}

    public int getID() {
        return userId;
    }

    public void setID(int userId) {
        this.userId = userId;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public int getAccountType() {
        return accountType;
    }

    public void setAccountType(int accountType) {
        this.accountType = accountType;
    }
}
public class Challenge8_5 {
}
