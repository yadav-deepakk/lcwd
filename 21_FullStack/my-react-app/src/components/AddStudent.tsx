import { useState } from "react";
import { BASE_URL_STUDENT_V1 } from "../constants/constants";
import type { Student } from "../models/Student";

const AddStudent = () => {

  // fields in form
  const [name, setName] = useState(""); 
  const [email, setEmail] = useState(""); 
  const [username, setUsername] = useState(""); 

  const [student, setStudent] = useState<Student| null>(null); 
  const [savedStudent, setSavedStudent] = useState<Student| null>(null); 

  const handleAddStudent = (event:React.FormEvent<HTMLFormElement>) => {
    event.preventDefault(); 
    console.log("Trying to add new student.")

    if(validateStudent()) return; // validation fails
    // createStudent(); 

    console.log("added a new student.")
  }

  const handleReset= () => {

  }

  const validateStudent = () => {

    if(!name) // name
    if(!email) // email
    if(!username) // username

    return true
  }

  const createStudent = () => {

    fetch(`${BASE_URL_STUDENT_V1}`, {
      method: "POST", 
      headers: { "Content-Type": "application/json", }, 
      body: JSON.stringify({
        name: "testing purpose", 
        email: "test@email.com", 
        username: "testUser", 
      })
    })
    .then(response => response.json())
    .then(savedData => setSavedStudent(savedData))
    .catch(error => console.log("error: ", error))

  }

  return (
    <>
    <form onSubmit={handleAddStudent}>
      <label htmlFor="name">Enter Name</label>
      <input 
        value={name} onChange={(e)=>setName(e.target.value)} 
        type="text" name="name" id="name" 
        placeholder="Enter your name" 
      />
      <br /> 

      <label htmlFor="email">Enter Email</label>
      <input 
        value={email} onChange={(e)=>setEmail(e.target.value)} 
        type="text" name="name" id="name" 
        placeholder="Enter your email" />
      <br /> 

      <label htmlFor="userName">Enter username</label>    
      <input 
        value={username} onChange={(e)=>setUsername(e.target.value)} 
        type="text" name="name" id="name" 
        placeholder="Enter your name" />  
      <br />

      <button type="reset">Reset</button>
      <button type="submit">Submit</button>
    </form>

    {savedStudent && (
        <div>
          <h3>Student Saved Successfully</h3>
          <p>Name: {savedStudent.name}</p>
          <p>Email: {savedStudent.email}</p>
          <p>Username: {savedStudent.username}</p>
        </div>
    )}
  </>

  )
}

export default AddStudent; 
