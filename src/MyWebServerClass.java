
import com.vmm.JHTTPServer;
import java.io.IOException;
import java.sql.ResultSet;
import java.util.Properties;
import java.util.Random;
import jdbc.DBLoader;

public class MyWebServerClass extends JHTTPServer {

    public MyWebServerClass(int port) throws IOException {
        super(port);
    }

    @Override
    public Response serve(String uri, String method, Properties header, Properties parms, Properties files) {
        Response res = new Response(HTTP_OK, "text/plain", "Server is ready.");
        System.out.println("uri----->" + uri);
        if (uri.contains("UserSignUp")) {
            //get all data from request
            String username = parms.getProperty("username");
            String email = parms.getProperty("email");
            String password = parms.getProperty("password");
            String phone = parms.getProperty("phone");
            String gender = parms.getProperty("gender");
            try {
                ResultSet rs = DBLoader.executeSQL("select * from users where username='" + username + "'");
                if (rs.next()) {
                    res = new Response(HTTP_OK, "text/plain", "Fails");
                } else {
                    //insert user details in database
                    String filename = saveFileOnServerWithRandomName(files, parms, "photo", "src/uploads");
                    String photo = "src/uploads/" + filename;
                    rs.moveToInsertRow();
                    rs.updateString("username", username);
                    rs.updateString("email", email);
                    rs.updateString("password", password);
                    rs.updateString("phone", phone);
                    rs.updateString("gender", gender);
                    rs.updateString("photo", photo);
                    rs.insertRow();
                    res = new Response(HTTP_OK, "text/plain", "success");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (uri.contains("UserLogIn")) {
            String username = parms.getProperty("username");
            String password = parms.getProperty("password");
            try {
                ResultSet rs = DBLoader.executeSQL("select * from users where username='" + username + "' and password='" + password + "'");
                if (rs.next()) {
                    //login successfull
                    res = new Response(HTTP_OK, "text/plain", "success");
                } else {
                    res = new Response(HTTP_OK, "text/plain", "fails");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (uri.contains("UserChangePassword")) {
            //get all data
            String username = parms.getProperty("username");
            String oldpassword = parms.getProperty("oldpassword");
            String newpassword = parms.getProperty("newpassword");
            //dbloader check 
            try {
                ResultSet rs = DBLoader.executeSQL("select * from users where username='" + username + "' and password='" + oldpassword + "'");
                if (rs.next()) {
                    //login successfull
                    rs.updateString("password", newpassword);
                    rs.updateRow();
                    res = new Response(HTTP_OK, "text/plain", "success");
                } else {
                    res = new Response(HTTP_OK, "text/plain", "fails");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (uri.contains("UserEditProfileWithoutPhoto")) {
            String username = parms.getProperty("username");
            String email = parms.getProperty("email");
            String phone = parms.getProperty("phone");
            try {

                ResultSet rs = DBLoader.executeSQL("select * from users where username='" + username + "'");
                if (rs.next()) {
                    //update row
                    rs.updateString("email", email);
                    rs.updateString("phone", phone);
                    rs.updateRow();
                    res = new Response(HTTP_OK, "text/plain", "success");
                } else {
                    res = new Response(HTTP_OK, "text/plain", "fails");
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        } else if (uri.contains("UserEditProfileWithPhoto")) {
            String username = parms.getProperty("username");
            String email = parms.getProperty("email");
            String phone = parms.getProperty("phone");
            try {

                ResultSet rs = DBLoader.executeSQL("select * from users where username='" + username + "'");
                if (rs.next()) {
                    //update row
                    String filename = saveFileOnServerWithRandomName(files, parms, "photo", "src/uploads");
                    String photo = "src/uploads/" + filename;
                    rs.updateString("email", email);
                    rs.updateString("phone", phone);
                    rs.updateString("photo", photo);
                    rs.updateRow();
                    res = new Response(HTTP_OK, "text/plain", "success");
                } else {
                    res = new Response(HTTP_OK, "text/plain", "fails");
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (uri.contains("getUserDetail")) {
            String username = parms.getProperty("username");
            System.out.println(username);
            try {
                ResultSet rs = DBLoader.executeSQL("select * from users where username='" + username + "'");
                String ans = "";
                if (rs.next()) {
                    String email = rs.getString("email");
                    String phone = rs.getString("phone");
                    String photo = rs.getString("photo");
                    ans += email + ";;" + phone + ";;" + photo;
                    res = new Response(HTTP_OK, "text/plain", ans);
                } else {
                    res = new Response(HTTP_OK, "text/plain", "fails");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (uri.contains("searchUser")) {
            String username = parms.getProperty("username");
            String keyword = parms.getProperty("keyword");
            try {
                ResultSet rs = DBLoader.executeSQL("select * from users where username like '" + keyword + "%' and username!='" + username + "'");

                String ans = "";
                String ifFollow = "no";
                while (rs.next()) {
                    String user = rs.getString("username");
                    String photo = rs.getString("photo");
                    ResultSet rs2 = DBLoader.executeSQL("select * from follow_user where follow_by='" + username + "'and follow_to='" + user + "'");
                    if (rs2.next()) {
                        ifFollow = "yes";
                    }
                    ans += user + ",," + photo + ",," + ifFollow + "$$";
                }
                res = new Response(HTTP_OK, "text/fails", ans);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (uri.contains("followUser")) {
            String followby = parms.getProperty("followby");
            String followto = parms.getProperty(("followto"));
            try {
                ResultSet rs = DBLoader.executeSQL("select * from follow_user where follow_by='" + followby + "'  and follow_to = '" + followto + "' ");
                if (rs.next()) {
                    rs.deleteRow();
                    res = new Response(HTTP_OK, "text/plain", "fails");
                } else {
                    rs.moveToInsertRow();
                    rs.updateString("follow_by", followby);
                    rs.updateString("follow_to", followto);
                    rs.insertRow();
                    res = new Response(HTTP_OK, "text/plain", "success");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else if (uri.contains("myFollowers")) {
            String loggedinuser = parms.getProperty("loggedinuser");
            System.out.println(loggedinuser);
            try {
                ResultSet rs = DBLoader.executeSQL("select * from follow_user where follow_to = '" + loggedinuser + "'");
                String ans = "";

                while (rs.next()) {

                    String followername = rs.getString("follow_by");
                    int followId = rs.getInt("follower_id");
                    ResultSet rs1 = DBLoader.executeSQL("select * from users where username='" + followername + "'");
                    if (rs1.next()) {
                        String photo = rs1.getString("photo");
                        ans += followername + ";;" + photo + ";;" + followId + "~~";
                    }
                }
                res = new Response(HTTP_OK, "text/plain", ans);

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (uri.contains("AddPost")) {
            String caption = parms.getProperty("caption");
            String username = parms.getProperty("username");
            try {
                ResultSet rs = DBLoader.executeSQL("select * from posts");
                rs.next();
                String filename = saveFileOnServerWithRandomName(files, parms, "photo", "src/uploads");
                String photo = "src/uploads/" + filename;
                rs.moveToInsertRow();
                rs.updateString("caption", caption);
                rs.updateString("username", username);
                rs.updateString("photo", photo);
                rs.insertRow();
                res = new Response(HTTP_OK, "text/plain", "success");

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (uri.contains("getAllPosts")) {
            String username = parms.getProperty("username");
            try {
                ResultSet rs = DBLoader.executeSQL("select * from posts where username='" + username + "'");
                String ans = "";
                while (rs.next()) {
                    String post_id = String.valueOf(rs.getInt("post_id"));
                    String photo = rs.getString("photo");
                    String date = rs.getString("date_time");
                    String caption = rs.getString("caption");
                    ans += post_id + ";;" + photo + ";;" + caption + ";;" + date + "~~";

                }
                res = new Response(HTTP_OK, "text/plain", ans);

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (uri.contains("userAddStory")) {
            String caption = parms.getProperty("caption");
            String postid = parms.getProperty("post_id");
            try {
                ResultSet rs = DBLoader.executeSQL("select * from story");
                rs.next();
                String filename = saveFileOnServerWithRandomName(files, parms, "photo", "src/uploads");
                String photo = "src/uploads/" + filename;
                rs.moveToInsertRow();
                rs.updateString("caption", caption);
                rs.updateString("postid", postid);
                rs.updateString("photo", photo);
                rs.insertRow();
                res = new Response(HTTP_OK, "text/plain", "success");

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (uri.contains("getAllStories")) {
            String post_id = parms.getProperty("post_id");
            try {
                ResultSet rs = DBLoader.executeSQL("select * from story where postid='" + post_id + "'");
                String ans = "";
                while (rs.next()) {
                    String story_id = rs.getString("story_id");
                    String photo = rs.getString("photo");
                    String date = rs.getString("date_time");
                    String caption = rs.getString("caption");
                    ans += story_id + ";;" + photo + ";;" + caption + ";;" + date + "~~";

                }
                res = new Response(HTTP_OK, "text/plain", ans);

            } catch (Exception e) {
                e.printStackTrace();

            }
        } else if (uri.contains("myFollowing")) {
            String loggedinuser = parms.getProperty("loggedinuser");
            System.out.println(loggedinuser);
            try {
                ResultSet rs = DBLoader.executeSQL("select * from follow_user where follow_by = '" + loggedinuser + "'");

                String ans = "";
                while (rs.next()) {
                    int followId = rs.getInt("follower_id");
                    String followername = rs.getString("follow_to");
                    ResultSet rs1 = DBLoader.executeSQL("select * from users where username='" + followername + "'");
                    if (rs1.next()) {
                        String photo = rs1.getString("photo");
                        ans += followername + ";;" + photo + ";;" + followId + "~~";
                    }
                }
                res = new Response(HTTP_OK, "text/plain", ans);

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (uri.contains("removeFollower")) {
//get id
            String id = parms.getProperty("followerId");
            try {
                ResultSet rs = DBLoader.executeSQL("select * from follow_user where followerid=" + id);
                if (rs.next()) {
                    rs.deleteRow();
                    //send response success
                    res = new Response(HTTP_OK, "text/plain", "success");
                } else {
                    res = new Response(HTTP_OK, "text/plain", "fails");
                }
            } catch (Exception e) {
            }
        } else if (uri.contains("unfollow")) {
            String id = parms.getProperty("followerId");
            try {
                ResultSet rs = DBLoader.executeSQL("select * from follow_user where followerid=" + id);
                if (rs.next()) {
                    rs.deleteRow();
                    //send response success
                    res = new Response(HTTP_OK, "text/plain", "success");
                } else {
                    res = new Response(HTTP_OK, "text/plain", "fails");
                }
            } catch (Exception e) {
            }
        } else if (uri.contains("ForgotPasswordCheck")) {
            String username = parms.getProperty("username");
            try {
                ResultSet rs = DBLoader.executeSQL("select * from users where username='" + username + "'");
                String ans = "";
                if (rs.next()) {
                    Random r = new Random();
                    int otp = r.nextInt((9999 - 100) + 1);
                    ans = ans + otp;
                }
                res = new Response(HTTP_OK, "text/plain", ans);

            } catch (Exception e) {
            }
        } else if (uri.contains("ForgotPasswordChange")) {
            String username = parms.getProperty("username");
            String newpass = parms.getProperty("newpassword");
            try {
                ResultSet rs = DBLoader.executeSQL("select * from users where username='" + username + "'");
                if (rs.next()) {
                    rs.updateString("password", newpass);
                    rs.updateRow();
                    res = new Response(HTTP_OK, "text/plain", "success");
                } else {
                    res = new Response(HTTP_OK, "text/plain", "fails");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (uri.contains("/GetResource")) {
            uri = uri.substring(1);
            uri = uri.substring(uri.indexOf("/") + 1);
            res = sendCompleteFile(uri);
            // System.out.println("Response reference to be send to client-------------" + res);
        } else if (uri.contains("deletePost")) {
            String id = parms.getProperty("postid");
            try {
                ResultSet rs = DBLoader.executeSQL("select * from posts where post_id=" + id);
                if (rs.next()) {
                    rs.deleteRow();
                    //send response success
                    res = new Response(HTTP_OK, "text/plain", "success");
                } else {
                    res = new Response(HTTP_OK, "text/plain", "fails");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (uri.contains("deleteStory")) {
            String id = parms.getProperty("storyid");
            try {
                ResultSet rs = DBLoader.executeSQL("select * from story where story_id=" + id);
                if (rs.next()) {
                    rs.deleteRow();
                    //send response success
                    res = new Response(HTTP_OK, "text/plain", "success");
                } else {
                    res = new Response(HTTP_OK, "text/plain", "fails");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (uri.contains("fetchFollowingPost")) {
            String username = parms.getProperty("loggedinuser");
            String ans = "";
            try {
                ResultSet rs = DBLoader.executeSQL("select * from follow_user where follow_by='" + username + "'");
                while (rs.next()) {
                    String follow_to = rs.getString("follow_to");
                    ResultSet rs2 = DBLoader.executeSQL("select * from posts where username='" + follow_to + "'");
                    while (rs2.next()) {
                        int post_id = rs2.getInt("post_id");
                        String date_time = rs2.getString("date_time");
                        String caption = rs2.getString("caption");
                        String photo = rs2.getString("photo");
                        String is_like = "";
                        int count_like = 0;
                        ResultSet rs3 = DBLoader.executeSQL("select * from like_table where postid ='" + post_id + "' and username='" + username + "' ");
                        if (rs3.next()) {
                            is_like = "yes";
                        } else {
                            is_like = "no";
                        }
                        ResultSet rs4 = DBLoader.executeSQL("select count(*) from like_table where postid=" + post_id);
                        if (rs4.next()) {
                            count_like = rs4.getInt("count(*)");
                        }
                        ans = ans + follow_to + ";;" + post_id + ";;" + date_time + ";;" + caption + ";;" + photo + ";;" + is_like + ";;" + count_like + "~~";
                    }
                }
                res = new Response(HTTP_OK, "text/plain", ans);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else if (uri.contains("likepost")) {
            int post_id = Integer.parseInt(parms.getProperty("post_id"));
            String username = parms.getProperty("username");
            String ans="";
            try {
                ResultSet rs = DBLoader.executeSQL("select * from like_table where postid= " + post_id + " and username='" + username + "'");
                if (rs.next()) {
                    rs.deleteRow();
                    ans = "unlike";
                } else {
                    rs.moveToInsertRow();
                    rs.updateString("username", username);
                    rs.updateInt("postid", post_id);
                    rs.insertRow();
                    ans = "like";
                }

                res = new Response(HTTP_OK, "text/plain", ans);

            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        return res;
    }

}
