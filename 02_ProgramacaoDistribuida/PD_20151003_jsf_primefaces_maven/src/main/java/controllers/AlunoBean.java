package controllers;

import entity.TbAlunoEntity;
import modelo.AlunoModelo;
import org.primefaces.context.RequestContext;
import org.primefaces.model.StreamedContent;
import rn.AlunoRN;
import util.RelatorioUtil;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.util.HashMap;
import java.util.List;

@ManagedBean(name = "alunoBean")
@SessionScoped
public class AlunoBean {
    AlunoRN alunoRN;


    private TbAlunoEntity alunoSelecionado;
    private List<TbAlunoEntity> alunos;
    private TbAlunoEntity aluno;
    private AlunoModelo modelo;

    private StreamedContent arquivoRetorno;
    private int tipoRelatorio;

    public void popularDataTable(){
        alunoRN = new AlunoRN();
        this.alunos = alunoRN.listarSemFiltro();
        modelo = new AlunoModelo(alunos);
    }

    public AlunoBean() {
        aluno = new TbAlunoEntity();
        popularDataTable();
    }

    public TbAlunoEntity getAlunoSelecionado() {
        return alunoSelecionado;
    }

    public void setAlunoSelecionado(TbAlunoEntity alunoSelecionado) {
        this.alunoSelecionado = alunoSelecionado;
    }

    public List<TbAlunoEntity> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<TbAlunoEntity> alunos) {
        this.alunos = alunos;
    }

    public TbAlunoEntity getAluno() {
        return aluno;
    }

    public void setAluno(TbAlunoEntity aluno) {
        this.aluno = aluno;
    }

    public AlunoModelo getModelo() {
        return modelo;
    }

    public void setModelo(AlunoModelo modelo) {
        this.modelo = modelo;
    }

    public void abrirDialog(){
        RequestContext requestContext = RequestContext.getCurrentInstance();
        requestContext.execute("wdgdlgAl.show()");
        //requestContext.execute("PF('wdgdlgAl').show()"); no prime 5
    }
    public void abrirDialogAlt(){
        RequestContext requestContext = RequestContext.getCurrentInstance();
        requestContext.execute("wdgdlgAlalt.show()");
    }
    public void salvar(){
        alunoRN = new AlunoRN();
        alunoRN.salvar(aluno);
        this.alunos = alunoRN.listarSemFiltro();
        aluno = new TbAlunoEntity();
        FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, "Inclusão", "Aluno incluído com Sucesso!");
        FacesContext.getCurrentInstance().addMessage(null, facesMessage);
    }
    public void alterar(){
        alunoRN = new AlunoRN();
        alunoRN.alterar(alunoSelecionado);
        this.alunos = alunoRN.listarSemFiltro();
        FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, "Alteração", "Aluno alterado com Sucesso!");
        FacesContext.getCurrentInstance().addMessage(null, facesMessage);
    }
    public void excluir(){
        alunoRN = new AlunoRN();
        alunoRN.excluir(alunoSelecionado);
        this.alunos = alunoRN.listarSemFiltro();
        FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, "Exclusão", "Aluno excluído com Sucesso!");
        FacesContext.getCurrentInstance().addMessage(null, facesMessage);
    }

    /*public StreamedContent getArquivoRetorno() {
        if (alunoSelecionado==null){
            FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", "Aluno não foi selecionado");
            FacesContext.getCurrentInstance().addMessage(null, facesMessage);
            return null;
        }
        else{
            String nomeRelatorioJasper = "Aluno";
            String nomeRelatorioSaida = "Aluno";
            RelatorioUtil relutil = new RelatorioUtil();
            HashMap parametroRelatorio = new HashMap();
            parametroRelatorio.put("pmat",alunoSelecionado.getMatricula());
            try {

                this.arquivoRetorno = relutil.geraRelatorio(parametroRelatorio, nomeRelatorioJasper, nomeRelatorioSaida, tipoRelatorio);
            } catch (Exception e) {
                FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", "Não foi possível gerar o Relatório!");
                FacesContext.getCurrentInstance().addMessage(null, facesMessage);
                return null;
            }
            return this.arquivoRetorno;
        }
    }*/


    public int getTipoRelatorio() {
        return tipoRelatorio;
    }

    public void setTipoRelatorio(int tipoRelatorio) {
        this.tipoRelatorio = tipoRelatorio;
    }
}