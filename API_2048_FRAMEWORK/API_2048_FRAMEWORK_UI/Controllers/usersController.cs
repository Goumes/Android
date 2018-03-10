using API_2048_FRAMEWORK_BL.Manejadoras;
using API_2048_FRAMEWORK_ET;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;

namespace API_2048_FRAMEWORK_UI.Controllers
{
    public class usersController : ApiController
    {
        ManejadoraUsuariosBL manejadora = new ManejadoraUsuariosBL();
        ListadoUsuariosBL listado = new ListadoUsuariosBL();
        // GET: api/users
        public IEnumerable<clsUsuario> Get()
        {
            return listado.getListadoUsuariosBL();
        }

        // GET: api/users/5
        public clsUsuario Get(String id)
        {
            return manejadora.getUsuarioPorId(id);
        }

        // POST: api/users
        public void Post([FromBody]clsUsuario value)
        {
            manejadora.addUsuario(value);
        }

        // PUT: api/users/5
        public void Put(String id, [FromBody]clsUsuario value)
        {
            value.id = id;
            manejadora.updateUsuario(value);
        }

        // DELETE: api/ApiWithActions/5
        public void Delete(String id)
        {
            manejadora.borrarUsuario(id);
        }
    }
}
