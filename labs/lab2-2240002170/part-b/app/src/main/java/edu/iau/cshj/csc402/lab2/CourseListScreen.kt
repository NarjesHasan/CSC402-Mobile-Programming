package edu.iau.cshj.csc402.lab2

// Task 10 — Course List Screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import edu.iau.cshj.csc402.lab2.ui.theme.AndroidGreen
import edu.iau.cshj.csc402.lab2.ui.theme.Navy
import edu.iau.cshj.csc402.lab2.ui.theme.ScreenBackground

data class Course(
    val code: String,
    val title: String,
    val credits: Int,
    val days: String
)

@Composable
fun CourseListScreen(modifier: Modifier = Modifier) {
    val courses = remember {
        listOf(
            Course("CSC 402", "Mobile Application Programming", 3, "Mon / Wed"),
            Course("CSC 311", "Database Systems", 4, "Sun / Tue"),
            Course("CSC 340", "Operating Systems", 3, "Mon / Wed"),
            Course("MATH 202", "Discrete Mathematics", 3, "Sun / Thu"),
            Course("ENG 214", "Technical Writing", 2, "Tue"),
            Course("CSC 202", "Data Structures and Algorithms", 3, "Sun / Tue"),
            Course("CSC 330", "Software Engineering Principles", 3, "Mon / Wed")
        )
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(ScreenBackground)
            .statusBarsPadding()
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Navy)
                .padding(20.dp)
        ) {
            Text(
                text = "CSC 402 Lab 2",
                color = Color.White,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "Task 10 - Lists & LazyColumn",
                color = Color.LightGray,
                fontSize = 14.sp
            )
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(4.dp)
                .background(AndroidGreen)
        )

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            items(courses) { course ->
                CourseRow(course)
            }
        }
    }
}

@Composable
fun CourseRow(course: Course) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 1.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(IntrinsicSize.Min),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // 5dp green bar on far left
            Box(
                modifier = Modifier
                    .width(5.dp)
                    .fillMaxHeight()
                    .background(AndroidGreen)
            )
            
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(16.dp)
            ) {
                Text(
                    text = course.code,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = Navy
                )
                Text(
                    text = course.title,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = course.days,
                    fontSize = 12.sp,
                    color = Color.Gray
                )
            }
            
            // Credits chip
            Surface(
                shape = RoundedCornerShape(8.dp),
                color = Navy.copy(alpha = 0.05f),
                modifier = Modifier.padding(end = 16.dp)
            ) {
                Text(
                    text = "${course.credits} Cr",
                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
                    color = Navy,
                    fontWeight = FontWeight.Bold,
                    fontSize = 12.sp
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CourseListScreenPreview() {
    CourseListScreen()
}
