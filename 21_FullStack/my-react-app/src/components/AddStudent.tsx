import { useState } from "react";
import { BASE_URL_STUDENT_V1 } from "../constants/constants";
import type { Student } from "../models/Student";

const AddStudent = () => {

  // fields in form
  const [name, setName] = useState(""); 
  const [email, setEmail] = useState(""); 
  const [username, setUsername] = useState(""); 

  const [savedStudent, setSavedStudent] = useState<Student| null>(null); 

  const handleAddStudent = (event:React.FormEvent<HTMLFormElement>) => {
    event.preventDefault(); 
    console.log("Trying to add new student.")

    if(!validateStudent()) return; // validation fails
    createStudent(); 

    console.log("added a new student.")
  }

  const handleReset= () => {

    setEmail("")
    setName("")
    setUsername("")

  }

  const validateStudent = () => {
    let errorMessage = ""; 
    if(!name || name.length <3 || name.length>12){
      errorMessage = errorMessage + " " + "name is invalid \n"; 
    } // name validation failed

    if(!email || !(/^[^\s@]+@[^\s@]+\.[^\s@]+$/.test(email))){
      errorMessage =  errorMessage + " " + "email is invalid \n"; 
    } // email validation failed

    if(!username || username.length <3 || username.length>12 ){
      errorMessage = errorMessage + " " + "username is invalid \n"; 
    } // username validation failed

    if(errorMessage) {
      alert(errorMessage); 
      return false; 
    }
    
    return true // validation passed
  }

  const createStudent = () => {

    let newStudent = {
      name,
      email, 
      username, 
    }

    fetch(`${BASE_URL_STUDENT_V1}`, {
      method: "POST", 
      headers: { "Content-Type": "application/json", }, 
      body: JSON.stringify(newStudent)
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

      <button type="reset" onClick={handleReset}>Reset</button>
      <button type="submit">Submit</button>
    </form>

    {savedStudent && (
        <div>
          <h4>Student Saved Successfully</h4><br />
          <span>Name: {savedStudent.name}</span> <br />
          <span>Email: {savedStudent.email}</span><br />
          <span>Username: {savedStudent.username}</span>
        </div>
    )}
  </>

  )
}

export default AddStudent; 
