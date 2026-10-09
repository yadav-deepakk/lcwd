import { useNavigate, useSearchParams } from "react-router";

const EditStudentDetails = () => {

  console.log("Edit student reached!")

  const [searchParams] = useSearchParams();
  const id = searchParams.get("id");
  const navigate = useNavigate()


  const validateForm = () => {
    // no validation as of now
    return true; 
  }

  
  return (
    <>
      <div>EditStudentDetails {id}</div>
      <form name="edit-student-form"> 
        <label htmlFor="name">Enter new name: </label>
        <input type="name" name="name" id="name" /> <br />

        <label htmlFor="email">Enter new email: </label>
        <input type="email" name="email" id="email" /><br />

        <label htmlFor="username">Enter new username: </label>
        <input type="username" name="username" id="username" /><br />

        <label htmlFor="image">Upload a profile image: </label>
        <input type='file' /> 

      </form>

    </>
  )
}

export default EditStudentDetails