package tacos.services;

import org.springframework.stereotype.Service;
import tacos.domain.Taco;
import tacos.repository.TacoRepository;

@Service
public class TacoService {

    private TacoRepository tacoRepository;

    public TacoService(TacoRepository tacoRepository) {
        this.tacoRepository = tacoRepository;
    }

    public void add(Taco taco){
        tacoRepository.save(taco);
    }
}
