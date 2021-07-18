package br.com.systemsgs.config;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.primefaces.model.StreamedContent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public abstract class BeanReportView extends BeanViewAbstract{

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private ReportUtilJasperSoftware reportUtilJasperSoftware;
	
	protected StreamedContent arquivoReport;
	protected int tipoRelatorio;
	protected List<?> listaCollectionReport;
	protected HashMap<Object, Object> parametrosRelatorio;
	protected String nomeRelatorioJasper = "relatorio";
	protected String nomeRelatorioSaida = "relatorio";
	
	public StreamedContent getArquivoReport() throws Exception{
		return getReportUtilJasperSoftware().geraRelatorio(getListaCollectionReport(), getParametrosRelatorio(), getNomeRelatorioJasper(), getNomeRelatorioSaida(), getTipoRelatorio());
	}
	
	public BeanReportView() {
		parametrosRelatorio = new HashMap<Object, Object>();
		listaCollectionReport = new ArrayList();
	}
	
	public ReportUtilJasperSoftware getReportUtilJasperSoftware() {
		return reportUtilJasperSoftware;
	}
	
	public void setReportUtilJasperSoftware(ReportUtilJasperSoftware reportUtilJasperSoftware) {
		this.reportUtilJasperSoftware = reportUtilJasperSoftware;
	}

	public int getTipoRelatorio() {
		return tipoRelatorio;
	}

	public void setTipoRelatorio(int tipoRelatorio) {
		this.tipoRelatorio = tipoRelatorio;
	}

	public List<?> getListaCollectionReport() {
		return listaCollectionReport;
	}

	public void setListaCollectionReport(List<?> listaCollectionReport) {
		this.listaCollectionReport = listaCollectionReport;
	}

	public HashMap<Object, Object> getParametrosRelatorio() {
		return parametrosRelatorio;
	}

	public void setParametrosRelatorio(HashMap<Object, Object> parametrosRelatorio) {
		this.parametrosRelatorio = parametrosRelatorio;
	}

	public String getNomeRelatorioJasper() {
		return nomeRelatorioJasper;
	}

	public void setNomeRelatorioJasper(String nomeRelatorioJasper) {
		
		if(nomeRelatorioJasper == null || nomeRelatorioJasper.isEmpty()) {
			nomeRelatorioJasper = "relatorio";
		}
		
		this.nomeRelatorioJasper = nomeRelatorioJasper;
	}

	public String getNomeRelatorioSaida() {
		return nomeRelatorioSaida;
	}

	public void setNomeRelatorioSaida(String nomeRelatorioSaida) {
		
		if(nomeRelatorioSaida == null || nomeRelatorioSaida.isEmpty()) {
			nomeRelatorioJasper = "relatorio";
		}
		
		this.nomeRelatorioSaida = nomeRelatorioSaida;
	}

	public void setArquivoReport(StreamedContent arquivoReport) {
		this.arquivoReport = arquivoReport;
	}
	
}
