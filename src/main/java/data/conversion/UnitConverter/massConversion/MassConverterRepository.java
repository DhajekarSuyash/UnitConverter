package data.conversion.UnitConverter.massConversion;

import data.conversion.UnitConverter.massConversion.entity.MassConversion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MassConverterRepository extends JpaRepository<MassConversion, Integer>
{
}
