using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using _2048_API_CORE_BL.Manejadoras;
using _2048_API_CORE_ET;
using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;

namespace _2048_API_CORE_UI.Controllers
{
    [Produces("application/json")]
    [Route("api/users")]
    public class usersController : Controller
    {
        ManejadoraUsuariosBL manejadora = new ManejadoraUsuariosBL();
        ListadoUsuariosBL listado = new ListadoUsuariosBL();
        // GET: api/users
        [HttpGet]
        [Authorize]
        public IEnumerable<clsUsuario> Get()
        {
            return listado.getListadoUsuariosBL();
        }

        // GET: api/users/5
        [HttpGet("{id}", Name = "Get")]
        [Authorize]
        public clsUsuario Get(String id)
        {
            return manejadora.getUsuarioPorId(id);
        }
        
        // POST: api/users
        [HttpPost]
        [Authorize]
        public void Post([FromBody]clsUsuario value)
        {
            manejadora.addUsuario(value);
        }
        
        // PUT: api/users/5
        [HttpPut("{id}")]
        [Authorize]
        public void Put(String id, [FromBody]clsUsuario value)
        {
            value.id = id;
            manejadora.updateUsuario(value);
        }
        
        // DELETE: api/ApiWithActions/5
        [HttpDelete("{id}")]
        [Authorize]
        public void Delete(String id)
        {
            manejadora.borrarUsuario(id);
        }
    }
}
