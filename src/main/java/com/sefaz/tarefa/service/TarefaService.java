package com.sefaz.tarefa.service;

import com.sefaz.tarefa.model.Tarefa;
import com.sefaz.tarefa.repository.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class TarefaService {

    @Autowired
    private TarefaRepository tarefaRepository;

    @Transactional
    public Tarefa criarTarefa(Tarefa tarefa) {
        return tarefaRepository.save(tarefa);
    }

    @Transactional
    public void excluirTarefa(Long id) {
        tarefaRepository.deleteById(id);
    }

    @Transactional
    public Tarefa editarTarefa(Long id, Tarefa tarefaAtualizada) {
        Optional<Tarefa> tarefaOptional = tarefaRepository.findById(id);
        if (tarefaOptional.isPresent()) {
            Tarefa tarefa = tarefaOptional.get();
            tarefa.setTitulo(tarefaAtualizada.getTitulo());
            tarefa.setDescricao(tarefaAtualizada.getDescricao());
            tarefa.setStatus(tarefaAtualizada.getStatus());
            if (tarefaAtualizada.getStatus() == Tarefa.Status.CONCLUIDA) {
                tarefa.setDataConclusao(LocalDateTime.now());
            }
            return tarefaRepository.save(tarefa);
        }
        return null;
    }

    @Transactional(readOnly = true)
    public List<Tarefa> listarTodasTarefas() {
        return tarefaRepository.findAll();
    }
}