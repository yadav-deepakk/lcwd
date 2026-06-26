import StudentList from "./components/StudentList";
import StudentDetails from "./components/StudentDetails";
import AddStudent from "./components/AddStudent";
import { BrowserRouter, Route, Routes } from "react-router";
import EditStudentDetails from "./components/Edit";

function App() {

  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<StudentList />} />
        <Route path="/students" element={<StudentList />} />
        <Route path="/add-student/" element={<AddStudent />} />
        <Route path="/view-student/:id" element={<StudentDetails />} />
        <Route path="/edit-student" element={<EditStudentDetails />} />
      </Routes>
    </BrowserRouter>                     
  );
}

export default App;
