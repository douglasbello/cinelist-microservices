<h1 align="center">Cinelist</h1>

<p>
Projeto <b>Spring</b> com <b>Arquitetura de Microserviços</b> onde usuários podem cadastrar contas, administrar listas de filmes e séries favoritas, watchlist, fazer avaliações, adicionar comentários,
ver catálogos específicos (em alta e lançamentos) e receber recomendações personalizadas.
</p>

<hr>
<h3>Serviços</h3>
<p>
    <b>Accounts (Kotlin)</b>
        <ul>
            <li>Cadastro e edição de usuários.</li>
            <li>Implementação de lista de favoritos e lista de conteúdo para assistir.</li>
        </ul>
</p>

<p>
    <b>Gateway</b>
        <ul>
            <li>Implementação simples de um <b>Spring Cloud Gateway</b>.</li>
        </ul>
</p>

<p>
    <b>Authentication</b>
        <ul>
            <li>Serviço onde é feita a autenticação de usuários.</li>
            <li>Também é feita a autorização dos demais serviços.</li>
        </ul>
</p>

<p>
    <b>Cast</b>
        <ul>
            <li>Cadastro e gerenciamento de funcionários (atores, diretores, produtores, etc).</li>
            <li>Vínculo de funcionário com filme ou série. </li>
            <li>Cada serviço tem seu próprio banco, então é utilizado comunicação síncrona <b>(Feign)</b> para verificar se uma mídia existe antes de criar o vínculo.</li>
        </ul>
</p>

<p>
    <b>Catalog</b>
        <ul>
            <li>Cadastro e edição de filmes e séries.</li>
            <li>Consultas de mídias populares e lançamentos.</li>
        </ul>
</p>

<p>
    <b>Config</b>
    <ul>
        <li>Implementação de <b>Spring Cloud Config Server</b> utilizando este <a href="github.com/douglasbello/cinelist-microservices-configserver">repositório.</a></li>
    </ul>
</p>

<p>
    <b>Discovery</b>
    <ul>
        <li>Implementação de um <b>Service Discovery Server</b> utilizando <b>Netflix Eureka</b>.</li>
    </ul>
</p>

<p>
    <b>Mailsender</b>
    <ul>
        <li>Serviço para disparo de emails, este serviço é um <b>Kafka Consumer</b>.</li>
    </ul>
</p>

<p>
    <b>Ratings</b>
    <ul>
        <li>Avaliação de filmes e séries.</li>
        <li>Comentários para filmes e séries.</li>
    </ul>
</p>

<p>
    <b>Recommendation</b>
        <ul>
            <li>Serviço para recomendação de conteúdo para o usuário utilizando <a href="https://en.wikipedia.org/wiki/Collaborative_filtering">collaborative filtering</a>.</li>
        </ul>
</p>

<hr>

<h3>Design Patterns usados</h3>

<ul>
    <li>Builder</li>
    <li>Data Transfer Object</li>
</ul>

<hr>

<h3>Tecnologias usadas</h3>

<ul>
    <li>Java 17</li>
    <li>Kotlin</li>
    <li>Spring Boot (JPA, Security, Web)</li>
    <li>Spring Cloud Netflix (Config Server, Discovery, Gateway)</li>
    <li>Spring Cloud Open Feign</li>
    <li>Cache com Redis</li>
    <li>Docker</li>
    <li>PostgreSQL</li>
    <li>Mensageria com Apache Kafka</li>
</ul>

<hr>

<h3>TODO</h3>
<ul>
    <li>Implementar Spring Security.</li>
    <li>Implementar o serviço de recomendações.</li>
    <li>Implementação do serviço de disparos de emails.</li>
    <li>Migrar as configurações de todos os serviços para o Config Server.</li>
    <li>Dockerizar todos serviços.</li>
</ul>
