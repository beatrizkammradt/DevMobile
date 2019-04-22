package com.example.udesc.myapplication;

import java.util.ArrayList;

public class Construtor {
    private Alternativas alternativa1;
    private Alternativas alternativa2;
    private Alternativas alternativa3;
    private Alternativas alternativa4;
    private ImgAlternativas imgAlternativa1;
    private ImgAlternativas imgAlternativa2;
    private ImgAlternativas imgAlternativa3;
    private ImgAlternativas imgAlternativa4;
    private Pergunta pergunta1;
    private Marcador marcador;

    public Construtor(int i, int type){

        marcador = new Marcador();
        if(type == 0) {
            /* faz essa merda retornar direito*/
            this.alternativa1 = new Alternativas(i + (2 * (i - 1)), getText(i + (2 * (i - 1))));
            this.alternativa2 = new Alternativas(i + (2 * (i - 1) + 1), getText(i + (2 * (i - 1)) + 1));
            this.alternativa3 = new Alternativas(i + (2 * (i - 1) + 2), getText(i + (2 * (i - 1)) + 2));
            this.alternativa4 = new Alternativas(i + (2 * (i - 1) + 2), getText(i + (2 * (i - 1)) + 3));
        }else{
            this.imgAlternativa1 = new ImgAlternativas(i + (2 * (i - 1)));
            this.imgAlternativa2 = new ImgAlternativas(i + (2 * (i - 1) + 1));
            this.imgAlternativa3 = new ImgAlternativas(i + (2 * (i - 1) + 2));
            this.imgAlternativa4 = new ImgAlternativas(i + (2 * (i - 1) + 3));
        }


        this.pergunta1 = new Pergunta(i,getTitulo(i, type),alternativa1,alternativa2,alternativa3);
    }

    public Alternativas getAlternativa1() {
        return alternativa1;
    }

    public Marcador getMarcador() {
        return marcador;
    }

    public void setMarcador(ArrayList<Integer> lst){
        if(lst != null && lst.size() == 4) {
            this.marcador.setList(lst);
        }
    }

    public String getText(int i){
        // texto dos botões com as respotas possiveis, tem que definir qual botão será de qual professor
        switch(i){
            case 1:
                return "Algo que os fizesse aprender da maneira difícil.";
            case 2:
                return "Algo que nem Linus Torvalds conseguiria resolver.";
            case 3:
                return "Não passaria trabalhos.";
            case 4:
                return " Algo que eu gostaria de ter feito como aluno.";
            case 5:
                return "Alguém para admirar e seguir o exemplo.";
            case 6:
                return "Eu não me importo, só quero que eles aprendam.";
            case 7:
                return "Alguém muito superior e mais experiente.";
            case 8:
                return "Alguém que não é mau.";
                default:
                    break;
        }
        return "erro";
    }

    public Alternativas getAlternativa4() {
        return alternativa4;
    }

    public String getTitulo(int i, int type){
        //texto das perguntas que aparecerá no topo da tela
        if (type == 1) {
            switch (i) {
                case 1:
                    return "Qual destes animais você escolheria?";
                case 2:
                    return "Qual destas bebidas você escolheria?";
                case 3:
                    return "Qual destas peças de roupa você escolheria";
                default:
                    break;
            }
            return "erro";
        }
        else{
            switch (i) {
                case 1:
                    return "Que tipo de trabalho você passaria para seus alunos?";
                case 2:
                    return "Como você gostaria de ser visto por seu aluno?";
                default:
                    break;
            }
            return "erro";
        }
    }

    public void addMarcador(int e) {
        this.marcador.addPoint(e);
    }

    public int getResult(){
        return this.marcador.findTeacher();
    }

    public Alternativas getAlternativa2() {
        return alternativa2;
    }

    public Alternativas getAlternativa3() {
        return alternativa3;
    }

    public Pergunta getPergunta1() {
        return pergunta1;
    }

    public ImgAlternativas getImgAlternativa1() {
        return imgAlternativa1;
    }

    public ImgAlternativas getImgAlternativa2() {
        return imgAlternativa2;
    }

    public ImgAlternativas getImgAlternativa3() {
        return imgAlternativa3;
    }

    public ImgAlternativas getImgAlternativa4() {
        return imgAlternativa4;
    }
}
