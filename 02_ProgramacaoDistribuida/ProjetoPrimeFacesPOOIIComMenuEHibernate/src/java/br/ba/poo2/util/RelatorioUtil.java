package br.ba.poo2.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;

import javax.faces.context.FacesContext;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRHtmlExporter;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.export.oasis.JROdtExporter;
import net.sf.jasperreports.engine.util.JRLoader;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;


public class RelatorioUtil {

	public static final int	RELATORIO_PDF							= 1;
	public static final int	RELATORIO_EXCEL                                                                                                             = 2;
	public static final int	RELATORIO_HTML							= 3;
	public static final int	RELATORIO_PLANILHA_OPEN_OFFICE                                  = 4;

	public StreamedContent geraRelatorio(HashMap parametrosRelatorio, String nomeRelatorioJasper, String nomeRelatorioSaida, int tipoRelatorio) throws Exception {
		StreamedContent arquivoRetorno = null;

		try {
			FacesContext context = FacesContext.getCurrentInstance();
			Connection conexao = this.getConexao();
			String caminhoRelatorio = context.getExternalContext().getRealPath("Relatorios");
			String caminhoArquivoJasper = caminhoRelatorio + File.separator + nomeRelatorioJasper + ".jasper";
			String caminhoArquivoRelatorio = null;
              
			JasperReport relatorioJasper = (JasperReport) JRLoader.loadObject(caminhoArquivoJasper);
			JasperPrint impressoraJasper = JasperFillManager.fillReport(relatorioJasper, parametrosRelatorio, conexao);
                        
                        if (impressoraJasper.getPages().size()==0)
                            throw new Exception("Não existem dados para gerar este relatório - Relatório em Branco!"); 
                        
			JRExporter tipoArquivoExportado = null;
			String extensaoArquivoExportado = "";
			File arquivoGerado = null;

			switch (tipoRelatorio) {
				case RelatorioUtil.RELATORIO_PDF :
					tipoArquivoExportado = new JRPdfExporter();
					extensaoArquivoExportado = "pdf";
					break;
				case RelatorioUtil.RELATORIO_HTML :
					tipoArquivoExportado = new JRHtmlExporter();
					extensaoArquivoExportado = "html";
					break;
				case RelatorioUtil.RELATORIO_EXCEL :
					tipoArquivoExportado = new JRXlsExporter();
					extensaoArquivoExportado = "xls";
					break;
				case RelatorioUtil.RELATORIO_PLANILHA_OPEN_OFFICE :
					tipoArquivoExportado = new JROdtExporter();
					extensaoArquivoExportado = "ods";
					break;
				default :
					tipoArquivoExportado = new JRPdfExporter();
					extensaoArquivoExportado = "pdf";
					break;
			}
			caminhoArquivoRelatorio = caminhoRelatorio + File.separator + nomeRelatorioSaida + "." + extensaoArquivoExportado;
			arquivoGerado = new java.io.File(caminhoArquivoRelatorio);
			tipoArquivoExportado.setParameter(JRExporterParameter.JASPER_PRINT, impressoraJasper);
			tipoArquivoExportado.setParameter(JRExporterParameter.OUTPUT_FILE, arquivoGerado);
			tipoArquivoExportado.exportReport();
			arquivoGerado.deleteOnExit();

			InputStream conteudoRelatorio = new FileInputStream(arquivoGerado);
			arquivoRetorno = new DefaultStreamedContent(conteudoRelatorio, "application/" + extensaoArquivoExportado, nomeRelatorioSaida + "." + extensaoArquivoExportado);
                        conexao.close();
		} catch (JRException e) {
                         System.out.println(e.getMessage());
			throw new Exception("Não foi possível gerar o relatório.", e);
		} catch (FileNotFoundException e) {
			throw new Exception("Arquivo do relatório não encontrado.", e);
                } catch (SQLException e) {
			throw new Exception("Falha na conexão com o banco.", e);
		}
                
		return arquivoRetorno;
	}

	private Connection getConexao() throws Exception {
		java.sql.Connection conexao = null;
		try {
			Context initContext = new InitialContext();
			Context envContext = (Context) initContext.lookup("java:/comp/env/");
			javax.sql.DataSource ds = (javax.sql.DataSource) envContext.lookup("jdbc/bd_pooII");
			conexao = (java.sql.Connection) ds.getConnection();
		} catch (NamingException e) {
			throw new Exception("Não foi possível encontrar o nome da conexão do banco.", e);
		} catch (SQLException e) {
			throw new Exception("Ocorreu um erro de SQL.", e);
		}
		return conexao;
	}
        
        public File getArquivo(HashMap parametrosRelatorio, String nomeRelatorioJasper, String nomeRelatorioSaida, int tipoRelatorio) throws Exception {
		File arquivoGerado = null;

		try {
			FacesContext context = FacesContext.getCurrentInstance();
			Connection conexao = this.getConexao();
			String caminhoRelatorio = context.getExternalContext().getRealPath("Relatorios");
			String caminhoArquivoJasper = caminhoRelatorio + File.separator + nomeRelatorioJasper + ".jasper";
			String caminhoArquivoRelatorio = null;
              
			JasperReport relatorioJasper = (JasperReport) JRLoader.loadObject(caminhoArquivoJasper);
			JasperPrint impressoraJasper = JasperFillManager.fillReport(relatorioJasper, parametrosRelatorio, conexao);
                        
                        if (impressoraJasper.getPages().size()==0)
                            throw new Exception("Não existem dados para gerar este relatório - Relatório em Branco!"); 
                        
			JRExporter tipoArquivoExportado = null;
			String extensaoArquivoExportado = "";
			

			switch (tipoRelatorio) {
				case RelatorioUtil.RELATORIO_PDF :
					tipoArquivoExportado = new JRPdfExporter();
					extensaoArquivoExportado = "pdf";
					break;
				case RelatorioUtil.RELATORIO_HTML :
					tipoArquivoExportado = new JRHtmlExporter();
					extensaoArquivoExportado = "html";
					break;
				case RelatorioUtil.RELATORIO_EXCEL :
					tipoArquivoExportado = new JRXlsExporter();
					extensaoArquivoExportado = "xls";
					break;
				case RelatorioUtil.RELATORIO_PLANILHA_OPEN_OFFICE :
					tipoArquivoExportado = new JROdtExporter();
					extensaoArquivoExportado = "ods";
					break;
				default :
					tipoArquivoExportado = new JRPdfExporter();
					extensaoArquivoExportado = "pdf";
					break;
			}
			caminhoArquivoRelatorio = caminhoRelatorio + File.separator + nomeRelatorioSaida + "." + extensaoArquivoExportado;
			arquivoGerado = new java.io.File(caminhoArquivoRelatorio);
			tipoArquivoExportado.setParameter(JRExporterParameter.JASPER_PRINT, impressoraJasper);
			tipoArquivoExportado.setParameter(JRExporterParameter.OUTPUT_FILE, arquivoGerado);
			tipoArquivoExportado.exportReport();
                        conexao.close();
		} catch (JRException e) {
                         System.out.println(e.getMessage());
			throw new Exception("Não foi possível gerar o relatório.", e);
                } catch (SQLException e) {
			throw new Exception("Falha na conexão com o banco.", e);
		}
		return arquivoGerado;
	}
        
}
