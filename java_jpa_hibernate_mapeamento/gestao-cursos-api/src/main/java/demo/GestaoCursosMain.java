package demo;

import entities.*;
import models.AlunoModel;
import models.CursoModel;
import models.MaterialCursoModel;

import java.time.LocalDate;
import java.util.List;

public class GestaoCursosMain {

    public static void main(String[] args) {
        AlunoModel alunoModel = new AlunoModel();
        CursoModel cursoModel = new CursoModel();

        Aluno aluno = new Aluno();
        Endereco endereco = new Endereco();
        Telefone telefone = new Telefone();
        Professor professor = new Professor();
        MaterialCurso materialCurso = new MaterialCurso();

        MaterialCursoModel materialCursoModel = new MaterialCursoModel();
        MaterialCurso m1 = new MaterialCurso();
        m1.setUrl("testestestes");

        Aluno a1 = new Aluno();
        a1.setEmail("jaozinho@hotmail.com");
        a1.setNomeCompleto("Joao cleber Silmarilio");
        a1.setNascimento(LocalDate.of(1995,5,06));

        Aluno a2 = new Aluno();
        a2.setEmail("celebrinbor@hotmail.com");
        a2.setNomeCompleto("Celebrinbor Nodor Silmarilio");
        a2.setNascimento(LocalDate.of(0001,3,21));

        Curso c1 = new Curso();
        c1.setNome("Curso Extensivo de Senhor dos Aneis");
        c1.setSigla("CESA");

        materialCursoModel.create(m1);

        // 1) Criando um produto
        alunoModel.create(a1);
        alunoModel.create(a2);
        cursoModel.create(c1);

        alunoModel.update(alunoModel.findById(1L));
        alunoModel.findAll();

        cursoModel.update(c1);
        cursoModel.findById(c1.getId());
//
        alunoModel.delete(alunoModel.findById(a1.getId()));

    }
}
