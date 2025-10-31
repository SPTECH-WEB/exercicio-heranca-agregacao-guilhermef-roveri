package school.sptech;

public  class Desenvolvedor {
    protected String nome;
    protected Integer qtdHoras;
    protected Double valorHora;

    public Desenvolvedor(){

    }


    public Double calcularSalario(){
       return qtdHoras * valorHora;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getQtdHoras() {
        return qtdHoras;
    }

    public void setQtdHoras(Integer qtdHoras) {
        this.qtdHoras = qtdHoras;
    }

    public Double getValorHora() {
        return valorHora;
    }

    public void setValorHora(Double valorHora) {
        this.valorHora = valorHora;
    }

    @Override
    public String toString() {
        return "Desenvolvedor{" +
                "nome='" + nome + '\'' +
                ", qtdHoras=" + qtdHoras +
                ", valorHora=" + valorHora +
                '}';
    }
}
