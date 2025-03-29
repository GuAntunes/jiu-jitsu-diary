package br.com.gustavoantunes.jiujitsudiary;

import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;
import static com.tngtech.archunit.library.Architectures.layeredArchitecture;

@AnalyzeClasses(
        packages = "br.com.gustavoantunes.jiujitsudiary",
        importOptions = {
                ImportOption.DoNotIncludeTests.class,
                ImportOption.DoNotIncludeJars.class
        }
)
public class ArchitectureTest {

    // Nomenclature Rules
    @ArchTest
    static final ArchRule controllersShouldEndWithController = classes()
            .that().resideInAPackage("..infrastructure.controller..")
            .should().haveSimpleNameEndingWith("Controller")
            .allowEmptyShould(true);

    @ArchTest
    static final ArchRule servicesShouldEndWithService = classes()
            .that().resideInAPackage("..application.service..")
            .should().haveSimpleNameEndingWith("Service")
            .allowEmptyShould(true);

    @ArchTest
    static final ArchRule useCasesShouldEndWithUseCase = classes()
            .that().resideInAPackage("..application.port.in..")
            .should().beInterfaces()
            .andShould().haveSimpleNameEndingWith("UseCase")
            .allowEmptyShould(true);

    @ArchTest
    static final ArchRule portOutShouldFollowNamingConvention = classes()
            .that().resideInAPackage("..application.port.out..")
            .should().beInterfaces()
            .andShould().haveSimpleNameEndingWith("Port")
            .orShould().haveSimpleNameEndingWith("Repository")
            .orShould().haveSimpleNameEndingWith("Gateway")
            .allowEmptyShould(true);

    @ArchTest
    static final ArchRule repositoriesShouldEndWithRepository = classes()
            .that().resideInAPackage("..infrastructure.repository..")
            .should().haveSimpleNameEndingWith("Repository")
            .allowEmptyShould(true);

    @ArchTest
    static final ArchRule entitiesShouldNotHaveSuffix = classes()
            .that().resideInAPackage("..domain.model..")
            .should().haveSimpleNameNotEndingWith("Entity")
            .allowEmptyShould(true);

    // Dependency Rules
    @ArchTest
    static final ArchRule domainShouldNotDependOnOtherLayers = noClasses()
            .that().resideInAPackage("..domain..")
            .should().dependOnClassesThat().resideInAnyPackage(
                    "..application..",
                    "..infrastructure.."
            ).allowEmptyShould(true);

    @ArchTest
    static final ArchRule applicationLayerDependencies = noClasses()
            .that().resideInAPackage("..application..")
            .should().dependOnClassesThat().resideInAPackage("..infrastructure..")
            .allowEmptyShould(true);

    // Spring Annotations Rules
    @ArchTest
    static final ArchRule springControllersOnlyInInfrastructure = noClasses()
            .that().areAnnotatedWith("org.springframework.web.bind.annotation.RestController")
            .or().areAnnotatedWith("org.springframework.stereotype.Controller")
            .should().resideOutsideOfPackage("..infrastructure.controller..")
            .allowEmptyShould(true);

    @ArchTest
    static final ArchRule springServiceOnlyInApplicationService = noClasses()
            .that().areAnnotatedWith("org.springframework.stereotype.Service")
            .should().resideOutsideOfPackage("..application.service..")
            .allowEmptyShould(true);

    @ArchTest
    static final ArchRule springRepositoryOnlyInInfrastructure = noClasses()
            .that().areAnnotatedWith("org.springframework.stereotype.Repository")
            .should().resideOutsideOfPackage("..infrastructure.repository..")
            .allowEmptyShould(true);

    @ArchTest
    static final ArchRule domainShouldNotUseSpringAnnotations = noClasses()
            .that().resideInAPackage("..domain..")
            .should().beAnnotatedWith("org.springframework..")
            .allowEmptyShould(true);

    // Port Access Rules
    @ArchTest
    static final ArchRule inputPortsAccessRule = classes()
            .that().resideInAPackage("..application.port.in..")
            .should().onlyBeAccessed().byClassesThat().resideInAnyPackage(
                    "..application.service..", "..infrastructure.controller.."
            )
            .allowEmptyShould(true);

    @ArchTest
    static final ArchRule outputPortsAccessRule = classes()
            .that().resideInAPackage("..application.port.out..")
            .should().onlyBeAccessed().byClassesThat().resideInAnyPackage(
                    "..application.service..","..infrastructure.repository.."
            )
            .allowEmptyShould(true);

    // Interface Implementation Rules
    @ArchTest
    static final ArchRule servicesShouldImplementUseCase = classes()
            .that().resideInAPackage("..application.service..")
            .should().dependOnClassesThat()
            .resideInAPackage("..application.port.in..")
            .because("Services should implement use cases from input ports")
            .allowEmptyShould(true);

    @ArchTest
    static final ArchRule repositoriesShouldImplementPorts = classes()
            .that().resideInAPackage("..infrastructure.repository..")
            .should().dependOnClassesThat()
            .resideInAPackage("..application.port.out..")
            .because("Repositories should implement interfaces from output ports")
            .allowEmptyShould(true);
}