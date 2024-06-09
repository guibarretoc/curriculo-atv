package com.example.demo.service;

import com.example.demo.model.Curriculo;
import com.example.demo.repository.CurriculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CurriculoService {

    private final CurriculoRepository curriculoRepository;

    @Autowired
    public CurriculoService(CurriculoRepository curriculoRepository) {
        this.curriculoRepository = curriculoRepository;
    }

    public Curriculo createCurriculo(Curriculo curriculo) {
        curriculo.setId(UUID.randomUUID());
        return curriculoRepository.save(curriculo);
    }

    public List<Curriculo> getAllCurriculos() {
        return curriculoRepository.findAll();
    }

    public Optional<Curriculo> getCurriculoById(UUID id) {
        return curriculoRepository.findById(id);
    }

    public Optional<Curriculo> updateCurriculo(Curriculo curriculo, UUID id) {
        return curriculoRepository.findById(id)
                .map(existingCurriculo -> {
                    existingCurriculo.setNome((curriculo.getNome()==null) ? existingCurriculo.getNome():curriculo.getNome());
                    existingCurriculo.setProfissao((curriculo.getProfissao()==null) ? existingCurriculo.getProfissao():curriculo.getProfissao());
                    existingCurriculo.setExperiencia((curriculo.getExperiencia()==null)? existingCurriculo.getExperiencia(): curriculo.getExperiencia());
                    existingCurriculo.setHabilidades((curriculo.getHabilidades() == null)? existingCurriculo.getHabilidades() : curriculo.getHabilidades());
                    existingCurriculo.setCurso((curriculo.getCurso() == null) ? existingCurriculo.getCurso(): curriculo.getCurso());
                    return curriculoRepository.save(existingCurriculo);
                });
    }

    public Boolean deletarCurriculo(UUID id){
        try{
            curriculoRepository.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
