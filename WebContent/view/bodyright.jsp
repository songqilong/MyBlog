<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path;
%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="<%=basePath%>/plugin/bootstrap.min.css">
<script type="text/javascript" src="<%=basePath%>/plugin/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="<%=basePath%>/plugin/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <article>
    <div contenteditable="true" spellcheck="false" class="example">
      <br>
      <article class="article">
        <header>
          <h1 class="text-center">文章标题</h1>
          <dl class="dl-inline">
            <dt>作者：</dt>
            <dd>Catouse</dd>
            <dt></dt>
            <dd class="pull-right"><span class="label label-success">NEW</span> <span class="label label-warning">火爆</span> <span class="label label-info">原创</span> <span class="label label-danger"><i class="icon-eye-open"></i> 235</span></dd>
          </dl>
        </header>
        <section class="article-content">
          <h1>Lorem ipsum dolor sit amet.</h1>
          <h2>Lorem ipsum dolor sit amet, consectetur.</h2>
          <h3>Lorem ipsum dolor sit amet, consectetur.</h3>
          <h4>Lorem ipsum dolor sit amet, consectetur.</h4>
          <h5>Lorem ipsum dolor sit amet, consectetur.</h5>
          <h6>Lorem ipsum dolor sit amet, consectetur.</h6>
          <p><a href="###4">Lorem ipsum dolor</a> sit amet, consectetur adipisicing elit. Autem, ad, libero hic voluptatem sapiente possimus recusandae laboriosam adipisci voluptates inventore perferendis nam aliquid odio nostrum voluptate quasi totam itaque. Veritatis, dolore, sint, reiciendis repellat est non enim tenetur unde odio eius recusandae ut quae vero incidunt dolorem excepturi consectetur itaque.</p>
          <blockquote>
            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer posuere erat a ante.</p>
            <small>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Repellat, officiis!</small>
          </blockquote>
          <h3>Lorem ipsum dolor sit amet, consectetur.</h3>
          <p>Voluptates, repellat, voluptatibus temporibus facere veritatis ab similique quas nobis provident ratione eum sequi officiis sunt atque reprehenderit ut ipsum vel tempora alias consectetur numquam consequatur dignissimos eligendi rerum voluptas cupiditate tempore neque quam itaque illo veniam aspernatur distinctio praesentium labore et quod autem officia est beatae fuga corrupti inventore.</p>
          <img src="docs/img/slide2.jpg" alt="">
          <p>Architecto, officiis, incidunt, excepturi, repudiandae iusto quam tempora blanditiis sed quae aliquam quaerat soluta distinctio nulla vero at. Reprehenderit, aperiam laboriosam dolores eius quam autem magnam est fugiat minima nihil. Aut, minus, nemo iure fuga corporis repellendus perspiciatis iusto veritatis iste similique. Totam ut repudiandae nemo cumque aperiam aut sint.</p>
          <h2>Lorem ipsum dolor sit amet, consectetur.</h2>
          <ul>
            <li>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Perferendis soluta eveniet aspernatur facere quisquam veniam eos voluptates similique quis voluptas.</li>
            <li>Quaerat, aut atque praesentium quidem consequatur consequuntur repudiandae error maxime laboriosam nesciunt vitae illo laborum voluptas enim aliquid eius ad!</li>
            <li>Qui, soluta, ipsum, alias reiciendis iusto natus ullam distinctio nam exercitationem culpa veniam mollitia id sapiente quisquam nihil totam in.</li>
          </ul>
          <hr>
          <p>Magnam, modi, repellat beatae perferendis illo dicta illum dolore minus aperiam sit perspiciatis voluptas molestias eaque numquam ipsum deserunt at aut quam quisquam tenetur. Repellat, ratione nihil voluptate sit pariatur quasi ipsum? Sapiente, fugit nesciunt placeat ut expedita id inventore nobis iure adipisci ullam aliquid laboriosam facere officiis molestiae mollitia!</p>
          <table class="table table-hover">
            <thead>
              <tr>
                <th>Lorem ipsum.</th>
                <th>Quis, ut.</th>
                <th>Officia, odio?</th>
                <th>Eos, modi!</th>
                <th>Autem, doloremque!</th>
              </tr>
            </thead>
            <tbody>
              <tr>
                <td>Lorem ipsum.</td>
                <td>Dolor, rem.</td>
                <td>Iure, quaerat.</td>
                <td>Quibusdam, nam.</td>
                <td>Blanditiis, quo.</td>
              </tr>
              <tr>
                <td>Lorem ipsum.</td>
                <td>Aliquid, dicta.</td>
                <td>Architecto, perspiciatis.</td>
                <td>Eos, corporis.</td>
                <td>Similique, cum.</td>
              </tr>
              <tr>
                <td>Lorem ipsum.</td>
                <td>Id, minus!</td>
                <td>Eos, sit.</td>
                <td>Quae, dolores?</td>
                <td>Consectetur, deleniti!</td>
              </tr>
              <tr>
                <td>Lorem ipsum.</td>
                <td>Nam, excepturi.</td>
                <td>Assumenda, cumque!</td>
                <td>Vero, eligendi.</td>
                <td>Odit, porro.</td>
              </tr>
            </tbody>
          </table>
          <p>Adipisci reprehenderit placeat quos provident alias cupiditate ratione perspiciatis! Fuga, fugit id nisi sapiente voluptatibus quidem. Tempora, optio, animi, iste fugiat quisquam veniam aliquam sed labore at ad numquam eum nobis natus quasi magni. Sequi, dolor, sed, at, debitis accusamus ad qui voluptas est odit ipsa consequatur sint odio porro.</p>
          <ol>
            <li>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Eum, rerum, molestias possimus minima magnam libero iste amet ad. Ratione, deserunt, adipisci! Ducimus, nihil totam ad beatae corporis. Voluptatem, facere minima!</li>
            <li>Cupiditate, omnis, sit, ducimus, natus quo quam quia excepturi numquam deleniti totam odit illum voluptate id! Commodi, itaque magni saepe porro rem ducimus animi error ullam. Animi, consequatur totam natus.</li>
            <li>Quae, magni, dolorum odio quia labore asperiores sit dolorem vel hic laboriosam doloribus minima necessitatibus veritatis earum aliquid non rem ad id itaque pariatur repudiandae dolore eligendi illo nobis fuga.</li>
          </ol>
          <dl>
            <dt>Lorem.</dt>
            <dd>Lorem ipsum dolor sit amet.</dd>
            <dt>Ut.</dt>
            <dd>Necessitatibus, fugit repellat fugiat a.</dd>
            <dt>Aliquam.</dt>
            <dd>Obcaecati cum suscipit consequuntur voluptas?</dd>
            <dt>Minima!</dt>
            <dd>Esse soluta iure corporis porro.</dd>
            <dt>Sunt.</dt>
            <dd>Delectus quos amet quidem eaque!</dd>
          </dl>
          <p>Nemo, dolorum nisi sequi recusandae deserunt soluta nobis itaque expedita atque excepturi quidem sapiente qui perferendis maiores quas consectetur nulla quae libero impedit ea corporis eos dicta blanditiis ad quis quos quaerat reiciendis aliquam minima rem nesciunt odit est mollitia ipsa vero ratione ipsum. Dolorum, reprehenderit sint vero distinctio aliquam.</p>
        </section>
        <footer>
          <p class="pull-right text-muted">
            发布时间：2013年11月7日 16:44:21 &nbsp;点击数：234
          </p>
          <p class="text-important">本文版权所有归<a href="###">@catouse</a></p>         
        </footer>
      </article>
    </div>
  </article>
</body>
</html>