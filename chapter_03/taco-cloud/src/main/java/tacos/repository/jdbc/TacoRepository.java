package tacos.repository.jdbc;

import tacos.domain.Taco;

public interface TacoRepository {

    Taco save(Taco design);
}
