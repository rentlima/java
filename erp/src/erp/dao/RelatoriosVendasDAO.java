package erp.dao;

import erp.jdbc.ConnectionFactory;
import java.awt.Desktop;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Renato
 */
public class RelatoriosVendasDAO {

    Connection con = null;

    public RelatoriosVendasDAO() {
        this.con = new ConnectionFactory().getConnection();
    }

    public RelatoriosVendasDAO(Connection conexao) {
        this.con = conexao;
    }

    public boolean gerarRelatorioVendaPDF(int codigoVenda) throws SQLException, JRException {

        ResultSet rs = null;
        PreparedStatement st;
        String sql = "select clientes.id AS clientes_id, "
                + "clientes.nome AS clientes_nome, "
                + "clientes.cpf AS clientes_cpf, "
                + "clientes.endereco AS clientes_endereco, "
                + "clientes.cep AS clientes_cep, "
                + "clientes.cidade AS clientes_cidade, "
                + "clientes.uf AS clientes_uf, "
                + "clientes.telefone AS clientes_telefone, "
                + "clientes.bairro AS clientes_bairro, "
                + "produtos.codigo AS produtos_codigo, "
                + "produtos.nome AS produtos_nome, "
                + "produtos.quantidade AS produtos_quantidade, "
                + "produtos.valor_v AS produtos_valor_v, "
                + "tbvendas.id AS tbvendas_id, "
                + "tbvendas.subtotal AS tbvendas_subtotal, "
                + "tbitemvenda.qtd_produto AS tbitemvenda_qtd_produto, "
                + "tbitemvenda.idVenda AS tbitemvenda_idVenda, "
                + "tbitemvenda.idProduto AS tbitemvenda_idProduto "
                + " "
                + "from tbvendas inner join tbitemvenda on tbvendas.id  = tbitemvenda.idVenda inner join produtos "
                + "on tbitemvenda.idProduto = produtos.codigo inner join clientes on tbvendas.id_cliente = clientes.id where tbvendas.id ='" + codigoVenda + "'";
        PreparedStatement stm = con.prepareStatement(sql);

        rs = stm.executeQuery(sql);

        JRResultSetDataSource jr = new JRResultSetDataSource(rs);
        JasperPrint jp = JasperFillManager.fillReport("C:\\Users\\Renato\\Documents\\GitHub\\java\\erp\\src\\ireport/report1.jasper", new HashMap(), jr);
        JasperExportManager.exportReportToPdfFile(jp, "C:\\Users\\Renato\\Documents\\GitHub\\java\\erp\\relatorios/relatorioVendas.pdf");
        File file = new File("C:\\Users\\Renato\\Documents\\GitHub\\java\\erp\\relatorios/relatorioVendas.pdf");
        try {
            Desktop.getDesktop().open(file);
        } catch (Exception e) {
            //JOptionPane.showMessageDialog(null,"Erro : " + e);
        }
        file.deleteOnExit(); // retirar se quiser que o pdf fique salvo
        return true;

    }

    public boolean gerarRelatorioJasperViewPadrão(int idVenda) throws SQLException, JRException {

        ResultSet rs = null;

        PreparedStatement st;
        String sql = "select clientes.id AS clientes_id, "
                + "clientes.nome AS clientes_nome, "
                + "clientes.cpf AS clientes_cpf, "
                + "clientes.endereco AS clientes_endereco, "
                + "clientes.cep AS clientes_cep, "
                + "clientes.cidade AS clientes_cidade, "
                + "clientes.uf AS clientes_uf, "
                + "clientes.telefone AS clientes_telefone, "
                + "clientes.bairro AS clientes_bairro, "
                + "produtos.codigo AS produtos_codigo, "
                + "produtos.nome AS produtos_nome, "
                + "produtos.quantidade AS produtos_quantidade, "
                + "produtos.valor_v AS produtos_valor_v, "
                + "tbvendas.id AS tbvendas_id, "
                + "tbvendas.subtotal AS tbvendas_subtotal, "
                + "tbitemvenda.qtd_produto AS tbitemvenda_qtd_produto, "
                + "tbitemvenda.idVenda AS tbitemvenda_idVenda, "
                + "tbitemvenda.idProduto AS tbitemvenda_idProduto "
                + " "
                + "from tbvendas inner join tbitemvenda on tbvendas.id  = tbitemvenda.idVenda inner join produtos "
                + "on tbitemvenda.idProduto = produtos.codigo inner join clientes on tbvendas.id_cliente = clientes.id where tbvendas.id ='" + idVenda + "'";
        PreparedStatement stm = con.prepareStatement(sql);

        rs = stm.executeQuery(sql);

        JRResultSetDataSource jr = new JRResultSetDataSource(rs);
        JasperPrint jp = JasperFillManager.fillReport("C:\\relatoriosJava/report1.jasper", new HashMap(), jr);
        JasperViewer jv = new JasperViewer(jp, false);
        jv.setVisible(true);
        jv.toFront();

        return true;
    }

    public void string() {
        String sql = "SELECT"
                + "     clientes.id AS clientes_id, "
                + "     clientes.nome AS clientes_nome, "
                + "     clientes.rg AS clientes_rg, "
                + "     clientes.cpf AS clientes_cpf, "
                + "     clientes.endereco AS clientes_endereco, "
                + "     clientes.cep AS clientes_cep, "
                + "     clientes.cidade AS clientes_cidade, "
                + "     clientes.uf AS clientes_uf, "
                + "     clientes.telefone AS clientes_telefone, "
                + "     clientes.bairro AS clientes_bairro, "
                + "     produtos.codigo AS produtos_codigo, "
                + "     produtos.nome AS produtos_nome, "
                + "     produtos.tipo AS produtos_tipo, "
                + "     produtos.quantidade AS produtos_quantidade, "
                + "     produtos.valor_v AS produtos_valor_v, "
                + "     produtos.custo_c AS produtos_custo_c, "
                + "     produtos.fornecedor AS produtos_fornecedor, "
                + "     tbvendas.id AS tbvendas_id, "
                + "     tbvendas.data AS tbvendas_data, "
                + "     tbvendas.subtotal AS tbvendas_subtotal, "
                + "     tbvendas.nomeCliente AS tbvendas_nomeCliente, "
                + "     tbvendas.cpfCliente AS tbvendas_cpfCliente, "
                + "     tbvendas.id_cliente AS tbvendas_id_cliente, "
                + "     tbvendas.tipo_pagamento AS tbvendas_tipo_pagamento, "
                + "     tbitemvenda.idVenda AS tbitemvenda_idVenda, "
                + "     tbitemvenda.idProduto AS tbitemvenda_idProduto, "
                + "     tbitemvenda.qtd_produto AS tbitemvenda_qtd_produto "
                + " FROM "
                + "      produtos INNER JOIN tbitemvenda tbitemvenda ON produtos.codigo = tbitemvenda.idProduto "
                + "     INNER JOIN tbvendas tbvendas ON tbitemvenda.idVenda = tbvendas.id, "
                + "     clientes clientes where tbvendas.id ='' ";
    }
}
