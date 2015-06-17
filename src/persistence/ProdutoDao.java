package persistence;

import java.util.ArrayList;
import java.util.List;

import entity.Produto;

public class ProdutoDao extends Dao {
	
	
	public int create(Produto p)throws Exception	 {
		open();
		stmt = con.prepareStatement("insert into produto values(null,?,?,?)",stmt.RETURN_GENERATED_KEYS);
				
		stmt.setString(1, p.getNome());
		stmt.setDouble(2, p.getPreco());
		stmt.setInt(3, p.getQuantidade());
		stmt.execute();
		rs = stmt.getGeneratedKeys();
		rs.next();
		int chave= rs.getInt(1);
	close();
	return chave;
	}
	
	public List<Produto> findAll() throws Exception {
		open();
		stmt = con.prepareStatement("select * from produto");
		rs= stmt.executeQuery();
		List<Produto> lst = new ArrayList<Produto>();
		while (rs.next()) {
			Produto p = new Produto();
					p.setIdProduto(rs.getInt(1));
					p.setNome(rs.getString(2));
					p.setPreco(rs.getDouble(3));
					p.setQuantidade(rs.getInt(4));
					
					lst.add(p);
			}
		close();
		return lst;
	}
	
	public Produto findCode(Integer cod) throws Exception {
		open();
		stmt = con.prepareStatement("select * from produto where idproduto = ?");
		stmt.setInt(1, cod);
		rs= stmt.executeQuery();
		Produto p = null;
		if (rs.next()) {
			p = new Produto();
					p.setIdProduto(rs.getInt(1));
					p.setNome(rs.getString(2));
					p.setPreco(rs.getDouble(3));
					p.setQuantidade(rs.getInt(4));
					
					
			}
		close();
		return p;
	}
	public void  delete(Integer cod)throws Exception {
		
		open();
		stmt = con.prepareStatement("delete from produto where idproduto = ?");
		stmt.setInt(1, cod);
		stmt.execute();
		stmt.close();
		close();
		
	}
	
	public void update(Produto p)throws Exception	 {
		open();
		stmt = con.prepareStatement("updade produto set nome=?,preco=?,quantidade=? where idproduto=?)");
		
		
		stmt.setString(1, p.getNome());
		stmt.setDouble(2, p.getPreco());
		stmt.setInt(3, p.getQuantidade());
		stmt.setInt(4, p.getIdProduto());
		stmt.execute();
		stmt.close();
		rs = stmt.getGeneratedKeys();
		rs.next();
		
	close();
	
	}
	
	public static void main(String[] args) {
		Produto p = new Produto(null,"bone",300.,1);
		ProdutoDao  pd= new ProdutoDao();
		try {
			int chave = pd.create(p);
			System.out.println("Chave gerada: "+chave);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Erro:"+ e.getMessage());
		}
	}
	
	
}
