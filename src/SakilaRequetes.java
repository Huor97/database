// utilise la base de donnees MySQL Sakila
//ex de code JDBC


//importe des classes JDBC
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SakilaRequetes 
{
	public static void main(String[] args)
	{
			//Informations pour me connecter
			String protocol = "jdbc:";
			String sous_protocol = "mysql://";
			String ip = "localhost:3306/";
			String bd = "sakila";
			String parametre = "";//add your time zone 
			String login = "";//add your login here
			String password = "";//add your password here
			String url = protocol+sous_protocol+ip+bd+parametre;
			
			System.out.println(url);
			try //connection à la base
			{
			Connection connect = DriverManager.getConnection(url,login,password);
			
			/*System.out.println("succes");*/
			
			//requete SQL qui va être lancer
			String sql = "SELECT last_name, first_name FROM actor Limit 5";
			
			//objet pour utiliser la base de donnees
			Statement smt = connect.createStatement();
			
			System.out.println("\n"+sql);
			//lancement de la requete SQL, select
			ResultSet rs = smt.executeQuery(sql);
			
			while (rs.next()) {
				
				//affichage du resultat de requete
				
				System.out.println(rs.getString("last_name")+ " " +rs.getString("first_name"));
				
			}
			
			sql = "select count(*) from actor;";
			System.out.println("\n"+sql);
			rs = smt.executeQuery(sql);
			while (rs.next()) {
				System.out.println(rs.getInt(1));
				
			}
			
			//fermeture de la connection à la base
				connect.close();
			}
			catch(SQLException e)
			{
				e.printStackTrace();
				}
	}

}
