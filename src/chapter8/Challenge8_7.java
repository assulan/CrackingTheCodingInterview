package chapter8;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * Created by asus on 8/27/17.
 * Chat server.
 */

class ChatUserManager{
    private static ChatUserManager instance;
    private HashMap<Integer, ChatUser> usersById;
    private HashMap<String, ChatUser> usersByAccountName;
    private HashMap<Integer, ChatUser> onlineUsers;

    public static ChatUserManager getInstance(){
        if (instance == null) instance = new ChatUserManager();
        return instance;
    }

    public void addUser(ChatUser fromUser, String accountName){}
    public void approveAddRequest(AddRequest req){}
    public void rejectAddRequest(AddRequest req){}
    public void userSignedOn(String accountName){}
    public void userSignedOff(String accountName){}
}

class ChatUser{
    private int id;
    private UserStatus status = null;
    private HashMap<Integer, PrivateChat> privateChats;
    private List<GroupChat> groupChats;
    private HashMap<Integer, AddRequest> receivedAddRequests;
    private HashMap<Integer, AddRequest> sentAddRequests;
    private HashMap<Integer, ChatUser> contacts;
    private String accountName;
    private String fullName;

    public ChatUser(int id, String accountName, String fullName) {
        this.id = id;
        this.accountName = accountName;
        this.fullName = fullName;
    }

    public boolean sendMessageToUser(ChatUser to, String content){return  false;}
    public boolean sendMessageToGroupChat(int id, String content) {return  false; }

    public UserStatus getStatus() {
        return status;
    }

    public void setStatus(UserStatus status) {
        this.status = status;
    }

    public boolean addContact(ChatUser user){return false;}
    public void receivedAddRequest(AddRequest req){}
    public void sentAddRequest(AddRequest req){}
    public void removeAddRequest(AddRequest req){}
    public void requestAddUser(String accountName){}
    public void addConversation(PrivateChat conversation){}
    public void addConversation(GroupChat conversation){}

    public int getId() {
        return id;
    }

    public String getAccountName() {
        return accountName;
    }

    public String getFullName() {
        return fullName;
    }
}

class Conversation{
    private List<ChatUser> participants;
    private int id;
    private List<Message> messages;

    public boolean addMessage(Message m){return false;}

    public List<Message> getMessages() {
        return messages;
    }

    public int getId() {
        return id;
    }
}

class PrivateChat extends Conversation{
    private ChatUser user1;
    private ChatUser user2;
    public PrivateChat(ChatUser user1, ChatUser user2) {
    }
    public ChatUser getOtherParticipant(ChatUser primary){ return null;}
}

class GroupChat extends Conversation{
    public void removeParticipant(ChatUser user){}
    public void addParticipant(ChatUser user){}
}

class Message{
    private String content;
    private Date date;

    public Message(String content, Date date) {
        this.content = content;
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public Date getDate() {
        return date;
    }
}

class UserStatus{
    private String message;
    private UserStatusType type;

    public UserStatus(String message, UserStatusType type) {
        this.message = message;
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public UserStatusType getType() {
        return type;
    }

    public void setType(UserStatusType type) {
        this.type = type;
    }
}

enum UserStatusType{
    Offline, Away, Idle, Available, Busy
}

class AddRequest{
    private ChatUser fromUser;

    public ChatUser getFromUser() {
        return fromUser;
    }

    public void setFromUser(ChatUser fromUser) {
        this.fromUser = fromUser;
    }

    public ChatUser getToUser() {
        return toUser;
    }

    public void setToUser(ChatUser toUser) {
        this.toUser = toUser;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public RequestStatus getStatus() {
        return status;
    }

    public void setStatus(RequestStatus status) {
        this.status = status;
    }

    private ChatUser toUser;
    private Date data;
    private RequestStatus status;

    public AddRequest(ChatUser fromUser, ChatUser toUser, Date data) {
        this.fromUser = fromUser;
        this.toUser = toUser;
        this.data = data;
    }
}
enum RequestStatus{
    Unread, Read, Accepted, Rejected
}
public class Challenge8_7 {
}
