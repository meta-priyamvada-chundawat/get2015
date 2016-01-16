public class ContactSearch {
	public static List<Contact> searchForContacts (String nameString, String codeString)
    {   
        Contact[] contactList = [Select ID, Name From Contact Where (LastName =:nameString And MailingPostalCode =:codeString)];
        return contactList;
    }
}