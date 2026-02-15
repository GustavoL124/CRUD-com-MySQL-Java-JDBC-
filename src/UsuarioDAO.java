import java.sql.*;

public class UsuarioDAO {

    public void inserir(String nome, String email) throws Exception {
        Connection conn = Conexao.conectar();
        String sql = "INSERT INTO usuarios (nome, email) VALUES (?, ?)";

        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, nome);
        stmt.setString(2, email);
        stmt.execute();
        conn.close();
    }

    public void listar() throws Exception {
        Connection conn = Conexao.conectar();
        String sql = "SELECT * FROM usuarios";

        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        while (rs.next()) {
            System.out.println(rs.getInt("id") + " - " +
                               rs.getString("nome") + " - " +
                               rs.getString("email"));
        }

        conn.close();
    }

    public void atualizar(int id, String nome) throws Exception {
        Connection conn = Conexao.conectar();
        String sql = "UPDATE usuarios SET nome=? WHERE id=?";

        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, nome);
        stmt.setInt(2, id);
        stmt.execute();
        conn.close();
    }

    public void deletar(int id) throws Exception {
        Connection conn = Conexao.conectar();
        String sql = "DELETE FROM usuarios WHERE id=?";

        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, id);
        stmt.execute();
        conn.close();
    }
}
