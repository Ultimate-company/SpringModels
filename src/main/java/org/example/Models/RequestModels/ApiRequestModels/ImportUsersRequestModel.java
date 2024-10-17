package org.example.Models.RequestModels.ApiRequestModels;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Getter
@Setter
public class ImportUsersRequestModel extends  BaseRequest
{
    public static class Header {
        public static String FirstName = "First Name";
        public static String LastName = "Last Name";
        public static String Email = "Email";
        public static String Role = "Role";
        public static String DOB = "DOB";
        public static String Phone = "Phone";
        public static String AddressLine1 = "Address Line 1";
        public static String AddressLine2 = "Address Line 2";
        public static String City = "City";
        public static String State = "State";
        public static String ZipCode = "Zip Code";
    }

    private String usersDataTable;
    private String errorReportingTable;
    public static List<String> headers = new ArrayList<>(Arrays.asList(
            Header.FirstName, Header.LastName, Header.Email, Header.Role, Header.DOB, Header.Phone,
            Header.AddressLine1, Header.AddressLine2, Header.City, Header.State, Header.ZipCode
    ));
}