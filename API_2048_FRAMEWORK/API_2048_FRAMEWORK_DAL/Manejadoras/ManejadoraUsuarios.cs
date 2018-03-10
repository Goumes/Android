using API_2048_FRAMEWORK_DAL.Conexion;
using API_2048_FRAMEWORK_ET;
using System;
using System.Collections.Generic;
using System.Data.SqlClient;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace API_2048_FRAMEWORK_DAL.Manejadoras
{
    public class ManejadoraUsuarios
    {
        #region Metodos
        public clsUsuario buscarUsuarioPorId(String id)
        {

            clsMyConnection miConexion;


            SqlCommand miComando = new SqlCommand();

            SqlDataReader miLector;

            clsUsuario oUsuario = null;

            SqlConnection conexion;

            SqlParameter parameter;


            miConexion = new clsMyConnection();
            try
            {
                conexion = miConexion.getConnection();
                miComando.CommandText = "SELECT * FROM DB_users WHERE ID = @id";
                parameter = new SqlParameter();
                parameter.ParameterName = "@id";
                parameter.SqlDbType = System.Data.SqlDbType.VarChar;
                parameter.Value = id;
                miComando.Parameters.Add(parameter);


                miComando.Connection = conexion;
                miLector = miComando.ExecuteReader();

                //Si hay lineas en el lector
                if (miLector.HasRows)
                {
                    miLector.Read();
                    oUsuario = new clsUsuario();
                    oUsuario.id = (String)miLector["ID"];
                    oUsuario.highscore = Convert.ToInt32(miLector["Highscore"]);
                }

                miLector.Close();
                miConexion.closeConnection(ref conexion);
            }

            catch (SqlException exSql)
            {
                throw exSql;
            }

            return (oUsuario);

        }

        public int updateUsuarioDAL(clsUsuario usuario)
        {

            SqlConnection conexion;
            SqlCommand miComando = new SqlCommand();
            clsMyConnection miConexion = new clsMyConnection(); ;
            int resultado = 0;
            miComando.CommandText = "UPDATE DB_users SET Highscore=@highscore WHERE ID = @id";
            miComando.Parameters.Add("@id", System.Data.SqlDbType.VarChar).Value = usuario.id;
            miComando.Parameters.Add("@highscore", System.Data.SqlDbType.VarChar).Value = usuario.highscore;

            try
            {
                conexion = miConexion.getConnection();
                miComando.Connection = conexion;
                resultado = miComando.ExecuteNonQuery();
            }

            catch (Exception exSql)
            {
                throw exSql;
            }


            return resultado;
        }

        public int deleteUsuario(String id)
        {
            SqlConnection conexion;
            SqlCommand miComando = new SqlCommand();
            clsMyConnection miConexion = new clsMyConnection(); ;
            int resultado = 0;
            miComando.CommandText = "DELETE FROM DB_users WHERE ID = @id";
            miComando.Parameters.Add("@id", System.Data.SqlDbType.VarChar).Value = id;

            try
            {
                conexion = miConexion.getConnection();
                miComando.Connection = conexion;
                resultado = miComando.ExecuteNonQuery();
            }

            catch (Exception exSql)
            {
                throw exSql;
            }


            return resultado;
        }

        public int addUsuarioDAL(clsUsuario usuario)
        {
            int resultado = 0;

            SqlConnection conexion;
            SqlCommand miComando = new SqlCommand();
            clsMyConnection miConexion = new clsMyConnection(); ;
            miComando.CommandText = "INSERT INTO DB_users (ID, Highscore) VALUES (@id, @highscore)";
            miComando.Parameters.Add("@id", System.Data.SqlDbType.VarChar).Value = usuario.id;
            miComando.Parameters.Add("@highscore", System.Data.SqlDbType.VarChar).Value = usuario.highscore;


            try
            {
                conexion = miConexion.getConnection();
                miComando.Connection = conexion;
                resultado = miComando.ExecuteNonQuery();
            }

            catch (Exception exSql)
            {
                throw exSql;
            }

            return resultado;
        }
        #endregion
    }
}
