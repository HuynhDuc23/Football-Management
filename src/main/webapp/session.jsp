<!DOCTYPE html>
<%@page import="dao.sessionDao" %>
    <%@page import="model.session" %>
        <%@page import="java.util.ArrayList" %>
            <html lang="en">

            <head>
                <meta charset="UTF-8">
                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <title>Select Session Form</title>
                <style>
                    /* Reset default margin and padding */
                    body,
                    h1,
                    select,
                    input {
                        margin: 0;
                        padding: 0;
                    }

                    /* Apply a background color to the body */
                    body {
                        background-color: #f4f4f4;
                        font-family: Arial, sans-serif;
                        background: url('https://vebongdaonline.vn/wp-content/uploads/2023/07/Bundesliga-la-gi-6.png') no-repeat center center fixed;
                        background-size: cover;
                    }

                    /* Center the form within the container */
                    .container {
                        display: flex;
                        justify-content: center;
                        align-items: center;
                        height: 100vh;
                    }

                    /* Style the form */
                    form {
                        background-color: #fff;
                        padding: 20px;
                        border-radius: 10px;
                        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
                        text-align: center;
                    }

                    /* Style the form title */
                    h1 {
                        margin-bottom: 20px;
                        color: #333;
                    }

                    /* Style the select dropdown */
                    .form-select {
                        width: 100%;
                        padding: 10px;
                        border: 1px solid #ccc;
                        border-radius: 5px;
                        margin-bottom: 10px;
                    }

                    /* Style the submit button */
                    .submit-button {
                        background-color: #007bff;
                        color: #fff;
                        border: none;
                        padding: 10px 20px;
                        border-radius: 5px;
                        cursor: pointer;
                        transition: background-color 0.3s;
                    }

                    .submit-button:hover {
                        background-color: #0056b3;
                    }
                </style>
            </head>

            <body>
                <% sessionDao dao=new sessionDao(); ArrayList<session> sessions = dao.getAllSession() ;
                    %>
                    <div class="container">
                        <form action="HomeServlet" method="post">
                            <h2>Please Select Session</h2>
                            <select class="form-select" name="session">
                                <% for(int i=0 ; i < sessions.size();i++) { %>
                                    <option value="<%= sessions.get(i).getId()%>">
                                        <%= sessions.get(i).getYearS()%> - <%= sessions.get(i).getYearE() %>
                                    </option>
                                    <% }%>
                            </select>
                            <input class="submit-button" type="submit" value="SELECT">
                        </form>
                    </div>
            </body>

            </html>