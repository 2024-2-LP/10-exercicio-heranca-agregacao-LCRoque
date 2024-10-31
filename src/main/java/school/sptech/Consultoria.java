package school.sptech;

import school.sptech.especialistas.DesenvolvedorMobile;
import school.sptech.especialistas.DesenvolvedorWeb;

import java.util.ArrayList;
import java.util.List;

public class Consultoria {
    private String nome;
    private Integer vagas;
    private List<Desenvolvedor> desenvolvedores;

    public Consultoria(String nome, Integer vagas) {
        this.nome = nome;
        this.vagas = vagas;
        this.desenvolvedores = new ArrayList<>();
    }

    public Consultoria() {

    }

    public void contratar(Desenvolvedor desenvolvedor){
        if(desenvolvedores.size() < vagas){
            desenvolvedores.add(desenvolvedor);
        }
        System.out.println("Vagas atingidas");
    }

    public Boolean contratarFullstack(DesenvolvedorWeb desenvolvedor){
        if(desenvolvedor.isFullstack()){
            contratar(desenvolvedor);
            return true;
        }
        return false;
    }
    public Double getTotalSalarios(){
        Double qtdTotal = 0.0;
        for (Desenvolvedor desenvolvedorAtual : desenvolvedores) {
            qtdTotal += desenvolvedorAtual.calcularSalario();
        }
        return qtdTotal;
    }

    public Integer qtdDesenvolvedoresMobile(){
        Integer contador = 0;
        for (Desenvolvedor desenvolvedorAtual : desenvolvedores) {
            if(desenvolvedorAtual instanceof DesenvolvedorMobile){
                contador++;
            }
        }
        return contador;
    }

    public List<Desenvolvedor> buscarPorSalarioMaiorIgualQue(Double salario){
        List<Desenvolvedor> listaBusca = new ArrayList<>();

        for (Desenvolvedor desenvolvedorAtual : desenvolvedores) {
            if(desenvolvedorAtual.calcularSalario() >= salario){
                listaBusca.add(desenvolvedorAtual);
            }
        }
        return listaBusca;
    }

    public Desenvolvedor buscarMenorSalario(){
        if(desenvolvedores.isEmpty()){
            return null;
        }
        Double menorSalario = desenvolvedores.get(0).calcularSalario();
        Desenvolvedor desenvolvedorComMenorsalario = desenvolvedores.get(0);

        for (Desenvolvedor desenvolvedorAtual : desenvolvedores) {
            if(desenvolvedorAtual.calcularSalario() < menorSalario){
                menorSalario = desenvolvedorAtual.calcularSalario();
                desenvolvedorComMenorsalario = desenvolvedorAtual;
            }
        }
        return desenvolvedorComMenorsalario;
    }

    public List<Desenvolvedor> buscarPorTecnologia(String tecnologia){
        List<Desenvolvedor> listaTecDesejada = new ArrayList<>();
        for (Desenvolvedor desenvolvedorAtual : desenvolvedores) {
            if(desenvolvedorAtual instanceof DesenvolvedorWeb){
                if(((DesenvolvedorWeb) desenvolvedorAtual).getBackend().equals(tecnologia)){
                    listaTecDesejada.add(desenvolvedorAtual);
                }
                if(((DesenvolvedorWeb) desenvolvedorAtual).getFrontend().equals(tecnologia)){
                    listaTecDesejada.add(desenvolvedorAtual);
                }
                if(((DesenvolvedorWeb) desenvolvedorAtual).getSgbd().equals(tecnologia)){
                    listaTecDesejada.add(desenvolvedorAtual);
                }
            }
            if(desenvolvedorAtual instanceof DesenvolvedorMobile){
                if (((DesenvolvedorMobile) desenvolvedorAtual).getPlataforma().equals(tecnologia)){
                    listaTecDesejada.add(desenvolvedorAtual);
                }
                if(((DesenvolvedorMobile) desenvolvedorAtual).getLinguagem().equals(tecnologia)){
                    listaTecDesejada.add(desenvolvedorAtual);
                }
            }
        }
        return listaTecDesejada;
    }
    public Double getTotalSalariosPorTecnologia(String tecnologia){
        Double totalSalarios = 0.0;
        for (Desenvolvedor desenvolvedorAtual : desenvolvedores) {
            if(desenvolvedorAtual instanceof DesenvolvedorWeb){
                if(((DesenvolvedorWeb) desenvolvedorAtual).getBackend().equals(tecnologia)){
                    totalSalarios += desenvolvedorAtual.calcularSalario();
                }
                if(((DesenvolvedorWeb) desenvolvedorAtual).getFrontend().equals(tecnologia)){
                    totalSalarios += desenvolvedorAtual.calcularSalario();

                }
                if(((DesenvolvedorWeb) desenvolvedorAtual).getSgbd().equals(tecnologia)){
                    totalSalarios += desenvolvedorAtual.calcularSalario();
                }
            }
            if(desenvolvedorAtual instanceof DesenvolvedorMobile){
                if (((DesenvolvedorMobile) desenvolvedorAtual).getPlataforma().equals(tecnologia)){
                    totalSalarios += desenvolvedorAtual.calcularSalario();
                }
                if(((DesenvolvedorMobile) desenvolvedorAtual).getLinguagem().equals(tecnologia)){
                    totalSalarios += desenvolvedorAtual.calcularSalario();
                }
            }
        }
        return totalSalarios;
    }




    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getVagas() {
        return vagas;
    }

    public void setVagas(Integer vagas) {
        this.vagas = vagas;
    }

    public List<Desenvolvedor> getDesenvolvedores() {
        return desenvolvedores;
    }

    public void setDesenvolvedores(List<Desenvolvedor> desenvolvedores) {
        this.desenvolvedores = desenvolvedores;
    }
}
