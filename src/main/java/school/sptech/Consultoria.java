package school.sptech;

import school.sptech.especialistas.DesenvolvedorMobile;
import school.sptech.especialistas.DesenvolvedorWeb;

import java.util.ArrayList;
import java.util.List;

public class Consultoria {
    private String nome;
    private Integer vagas;
    private ArrayList<Desenvolvedor> desenvolvedores;

    public Consultoria(){
        this.desenvolvedores = new ArrayList<>();
    }

    public void contratar(Desenvolvedor desenvolvedor){
        if(desenvolvedores.size() < vagas){
            desenvolvedores.add(desenvolvedor);
        }
    }

    public void contratarFullstack(DesenvolvedorWeb desenvolvedor){
        if(desenvolvedor.isFullstack()){
            desenvolvedores.add(desenvolvedor);
        }
    }


    public Double getTotalSalarios(){
        Double valorTotal = 0.0;
        for(Desenvolvedor dev : desenvolvedores){
            valorTotal += dev.calcularSalario();
        }
        return valorTotal;
    }


    public Integer qtdDesenvolvedoresMobile(){
        Integer qtdDevMobile = 0;

        for(Desenvolvedor dev : desenvolvedores){
            if(dev instanceof DesenvolvedorMobile)
            qtdDevMobile ++;
        }
        return qtdDevMobile;
    }

    public List<Desenvolvedor> buscarPorSalarioMaiorIgualQue(Double salario){
        ArrayList<Desenvolvedor> devSalarioMaior = new ArrayList<>();
        for(Desenvolvedor dev : desenvolvedores){
            if(dev.calcularSalario() >= salario){
                devSalarioMaior.add(dev);
            }
        }
        return devSalarioMaior;
    }

    public Desenvolvedor buscarMenorSalario(){
        if(desenvolvedores.isEmpty()){
            return null;
        }
        Desenvolvedor menorSalario = desenvolvedores.get(0);
        for(Desenvolvedor dev : desenvolvedores){
            if(dev.calcularSalario() < menorSalario.calcularSalario()){
                menorSalario = dev;
            }
        }
        return menorSalario;
    }

    public List<Desenvolvedor> buscarPorTecnologia(String tecnologia){
        List<Desenvolvedor> devsTecnologia = new ArrayList<>();
        for(Desenvolvedor dev : desenvolvedores){
            if(dev instanceof DesenvolvedorWeb){
                if(((DesenvolvedorWeb) dev).getSgbd() == tecnologia || ((DesenvolvedorWeb) dev).getBackend() == tecnologia || ((DesenvolvedorWeb) dev).getFrontend() == tecnologia){
                    devsTecnologia.add(dev);
                }
            }else if(dev instanceof DesenvolvedorMobile){
                if(((DesenvolvedorMobile) dev).getLinguagem() == tecnologia || ((DesenvolvedorMobile) dev).getPlataforma() == tecnologia){
                    devsTecnologia.add(dev);
                }
            }
        }
        return devsTecnologia;
    }


    public Double getTotalSalariosPorTecnologia(String tecnologia){
        Double salarioDevs = 0.0;
        for(Desenvolvedor dev : desenvolvedores){
            if(dev instanceof DesenvolvedorWeb){
                if(((DesenvolvedorWeb) dev).getSgbd() == tecnologia || ((DesenvolvedorWeb) dev).getBackend() == tecnologia || ((DesenvolvedorWeb) dev).getFrontend() == tecnologia){
                    salarioDevs += dev.calcularSalario();
                }
            }else if(dev instanceof DesenvolvedorMobile){
                if(((DesenvolvedorMobile) dev).getLinguagem() == tecnologia || ((DesenvolvedorMobile) dev).getPlataforma() == tecnologia){
                    salarioDevs += dev.calcularSalario();
                }
            }
        }
        return salarioDevs;
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

    public ArrayList<Desenvolvedor> getDesenvolvedores() {
        return desenvolvedores;
    }

    public void setDesenvolvedores(ArrayList<Desenvolvedor> desenvolvedores) {
        this.desenvolvedores = desenvolvedores;
    }
}
