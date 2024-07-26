package com.sefaz.tarefa.controller;

import com.sefaz.tarefa.model.Tarefa;
import com.sefaz.tarefa.service.TarefaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tarefas")
@Tag(name = "Tarefa Controller", description = "Operações relacionadas a Tarefas")
public class TarefaController {

    @Autowired
    private TarefaService tarefaService;

    @PostMapping
    @Operation(summary = "Cria uma nova tarefa")
    public ResponseEntity<Tarefa> criarTarefa(@Validated @RequestBody Tarefa tarefa) {
        Tarefa novaTarefa = tarefaService.criarTarefa(tarefa);
        return new ResponseEntity<>(novaTarefa, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Exclui uma tarefa")
    public ResponseEntity<Void> excluirTarefa(@PathVariable Long id) {
        tarefaService.excluirTarefa(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Edita uma tarefa")
    public ResponseEntity<Tarefa> editarTarefa(@PathVariable Long id, @Validated @RequestBody Tarefa tarefaAtualizada) {
        Tarefa tarefa = tarefaService.editarTarefa(id, tarefaAtualizada);
        if (tarefa != null) {
            return new ResponseEntity<>(tarefa, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    @Operation(summary = "Consulta todas as tarefas")
    public ResponseEntity<List<Tarefa>> listarTodasTarefas() {
        List<Tarefa> tarefas = tarefaService.listarTodasTarefas();
        return new ResponseEntity<>(tarefas, HttpStatus.OK);
    }
}
